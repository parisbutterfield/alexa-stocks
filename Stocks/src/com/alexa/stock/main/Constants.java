package com.alexa.stock.main;

/***
 * 
 * @author parisbutterfield
 *
 */
public interface Constants {
//URLs and related
	static String yahooYQLBaseURL = "https://query.yahooapis.com/v1/public/yql?q=";
	static String yahooSymbolURL  = "http://autoc.finance.yahoo.com/autoc?query=";
	static String yahooSymbolQuery =  "&callback=YAHOO.Finance.SymbolSuggest.ssCallback";
	
	
//Voice related	
	static String introSpeechOutput = "Welcome to stocks. You can get stock information by company name or symbol on the NASDAQ and New York Stock Exchange";
	static String stockError = "An error occured retrieving information for stocks";
	static String stockQuestionNotUnderstood = "I'm unable to understand that question. Please try again";
	static String multipleResultsFound = "We found multiple symbols. Please ask again with one of the specific tickers found.";
	static String noStockFound = "Unable to find anything please try again";
	
//Formatting
	static String peroid = ".";
	static String hyphen = "-";
	static String space= " ";

//Other
	static String appName = "Stocks";
	
//Intents
	static String StockCompanyNameIntent = "StockCompanyName";
	static String StockSymbolNameIntent = "StockSymbolName";
	static String SymbolSlot = "Symbol";
	static String CompanyNameSlot = "CompanyName";
	
}
