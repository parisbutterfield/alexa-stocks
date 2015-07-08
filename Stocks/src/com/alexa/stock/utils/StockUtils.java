package com.alexa.stock.utils;
/***
 * 
 */
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alexa.stock.main.StockException;
import com.alexa.stock.query.model.Example;
import com.alexa.stock.query.model.Quote;
import com.alexa.stock.stocksearch.model.Container;
import com.alexa.stock.stocksearch.model.Result;
import com.alexa.stock.stocksearch.model.ResultSet;
import com.alexa.stock.utils.URIUtils.URIException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import static com.alexa.stock.main.Constants.*;

public class StockUtils 
{
    private static final Logger log = LoggerFactory.getLogger(StockUtils.class);
    
    /**
     * Support for speaking tickers such as AAPL when a slot is defined like
     * {A |SlotName} {A |SlotName} {P |SlotName} {L |SlotName}
     * 
     * Each letter is inserted into the slot and separated by "." or "-"
     * @param ticker
     * @return
     */
    public static String formatSymbol(String ticker) {
		log.debug("Ticker before formatting {} ", ticker);

    	String updated = ticker.replace(peroid, StringUtils.EMPTY).replace(hyphen, StringUtils.EMPTY).replace(space, StringUtils.EMPTY).trim();
    	
		log.debug("Ticker after formatting {} ", updated);
		
		return updated;

    	
    }

    /**
     * For speaking purposes when reading the stock symbol back to the user.
     * The hyphen allows each letter to be spoken when read by Alexa.
     * Example AAPL becomes A-A-P-L-
     * @param symbol
     * @return
     */
    public static String formatSymbolVoice(String symbol) {
    	if(symbol != null && !StringUtils.EMPTY.equals(symbol)) {
    	StringBuffer newString = new StringBuffer();
    		char [] symbolString = symbol.toCharArray();   	
    	for(char singleChar : symbolString) {
    		newString.append(singleChar + "-");
    		
    	}
    	return newString.toString();
    	
    	}
    	return StringUtils.EMPTY;
    }
	
    
    
    
	public static String getStockInformation(String companyName, String ticker) throws StockException {
		
		String voiceResponse = null;
		 
    	Map<String, String> validExchanges = new HashMap<String, String>();
    	validExchanges.put("NYSE","");
    	validExchanges.put("NASDAQ","");
    	List<Result> filteredSymbols = null;
    	
    	if(companyName != null) {
    	log.info("Company name {}, Doing a search", companyName);
         filteredSymbols = filteredSymbols(getStockSymbolFromCompanyName(companyName).getResult(), validExchanges);
    	} 
    	
    	if(filteredSymbols != null && filteredSymbols.size() == 1) {
            log.info("Getting the first stock returned");
    		voiceResponse = quoteInformation(getStockInformationForSymbol(filteredSymbols.get(0).getSymbol()));
    	} else if (filteredSymbols != null && filteredSymbols.size() > 1) {	    
    		//Alert the user of the multiple tickers.
    		voiceResponse = multipleResultResponse(filteredSymbols);    		
    		log.info("Found multiple symbols alert user");
    	} else if (companyName == null && ticker != null) { //We only have Symbol
    		voiceResponse = quoteInformation(getStockInformationForSymbol(ticker));
    		log.info("Looking for symbol infomation for symbol{}", ticker);

    	} else {
    		//We didn't find anything. Tell the user to try again
    		voiceResponse = noStockFound;
    	}
    	
    	return voiceResponse;
	}
	    
	    /**
	     * Spoken response for a stock.
	     * @param quote
	     * @return
	     */
	    public static String quoteInformation(Quote quote) {
	    	String response = null;
	    	if(quote != null && quote.getName() != null && quote.getSymbol() != null) {
	    		response = quote.getName() + " " + formatSymbolVoice(quote.getSymbol()) + " " 
	    	    + "last traded at " +  quote.getLastTradePriceOnly() 
	    	    + " on " + quote.getLastTradeTime() + " on " + quote.getLastTradeDate();
	    	} else {
	    		response = noStockFound;	
	    	}
	    	
	    	return response;
	    }
	    
	    
	    /**
	     * Method to speak when there are multiple results for a requested company. Iterates through each company found
	     * and creates a String with the Company name and Symbol
	     * @param multipleResults
	     * @return
	     */
	    public static String multipleResultResponse(List<Result> multipleResults) {
	    	
	    	String response = multipleResultsFound;
	    		for(Result quoteResult : multipleResults) {
	    			if(quoteResult != null) {
	    			response += "Company Name: " + quoteResult.getName() + " with the symbol " + formatSymbolVoice(quoteResult.getSymbol()) + ".\n"; 	
	    			}
	    	}	
	    			
    			log.info("Response {}", response);
	    return response;
	    	
	    }
	
	    /**
	     * Filters symbols on the Map passed in. If the getExchDisp() (Exchange Display Name) is in the map
	     * then the list of Results returned will contain the Result.
	     * @param symbols
	     * @param validExchanges
	     * @return
	     */
	    public static List<Result> filteredSymbols (List<Result> symbols, final Map<String,String> validExchanges) {
	    		if(symbols != null) {	
	    			CollectionUtils.filter(symbols, new Predicate<Result>() {
						public boolean evaluate(Result result) {
							if(result !=null && validExchanges.containsKey(result.getExchDisp())) {
								return true;
							}
							return false;
						}
	    			});
	    			return symbols;
	    		}
	    		return null;
	    	
	    }
    
    
    /**
     * Get the stock ticker from the company name.   
     * @param companyName
     * @return
     * @throws StockException
     */
    public static ResultSet getStockSymbolFromCompanyName(String companyName) throws StockException {
    	
   	    String query;
		try {
			query = yahooSymbolURL + URLEncoder.encode(companyName.trim(), "UTF-8") + yahooSymbolQuery;
			log.debug("URL {} ", query);
			String output = getRESTResource(query);
			log.debug("Response {} ", output);
	        output = output.substring("YAHOO.Finance.SymbolSuggest.ssCallback(".length(), output.length()-1);
	   		Container container = parseJson(output, Container.class);

	   			return container.getResultSet();
		
		} catch (Exception e) {
			throw new StockException(e.toString());
		}
    
    }
    
    /**
     * Query to the YQL API to retrieve information based on stock ticker.
     * We call the generic getRESTResource method
     * @param symbol
     * @return
     */
    public static Quote getStockInformationForSymbol(String symbol)  throws StockException {
    	
    	String query = "select * from yahoo.finance.quotes where symbol = \"" + symbol +
    		"\"&format=json&diagnostics=true&env=store://datatables.org/alltableswithkeys&callback=";
    	
		String response = null;
		String request = null;
		
		try {
			request =  yahooYQLBaseURL + URIUtils.encodeQuery(query);
		} catch (URIException e) {
			log.info("URIException e {}", e.toString());
			throw new StockException(e.toString());
		} 
		log.info("StockQuoteInformation request{}", request);
		response = getRESTResource(request);
		log.info("StockQuoteInformation response {}", response);
		Example example = parseJson(response, Example.class);
   		
	  return example.getQuery().getResults().getQuote();
		
		
    }
    
    /**
     * For a given URL returns the response if the the status code is 200. A response code of anything
     * other than 200 will throw and exception.
     * @param url
     * @return
     * @throws StockException
     */
    public static String getRESTResource(String url) throws StockException{
    	
    	try {
      		 
      	     ClientConfig clientConfig = new DefaultClientConfig();
      	        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
      	        Client client = Client.create(clientConfig);
       
      		WebResource webResource = client
      		   .resource(url);
       
      		ClientResponse response = webResource.accept("application/json")
                         .get(ClientResponse.class);
       
      		if (response.getStatus() != 200) {
      			log.error("URL is {} ", url);
      			
      			throw new StockException("Failed : HTTP error code : "
      	      			+ response.getStatus());
      		}
           			return response.getEntity(String.class);
       
      	  } catch (Exception e) {
  			log.error("Exception e{}", e.toString());
  			throw new StockException(e.toString());
      	  }
    }
    
    
    
    
    public static <T> T parseJson(String json, Class<T> resultType) throws StockException {
    	try { 
    		
    		ObjectMapper objectMapper = new ObjectMapper();
        
            return objectMapper.readValue(json, resultType);
    	  
    	} catch (Exception e) {
  			log.error("Unable to parse json {} exception {}", json, e.toString());
  			throw new StockException(e.toString());
          }
    }
    	
    
}
