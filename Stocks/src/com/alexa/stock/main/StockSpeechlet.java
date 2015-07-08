package com.alexa.stock.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alexa.stock.utils.StockUtils;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;

import static com.alexa.stock.main.Constants.*;

/***
 * 
 * @author parisbutterfield
 *
 */
public class StockSpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(StockSpeechlet.class);

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        // Here we are setting shouldEndSession to false to not end the session and
        // prompt the user for input
        return buildSpeechletResponse("Welcome", introSpeechOutput, false);
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        
        SpeechletResponse response;
		try {
			response = stockSpeechResponse(intent);
		} catch (StockException e) {
       	 	log.error("Error e {}", e.toString());
       	 	throw new SpeechletException("Invalid Intent");
		}
        
        if(response == null)
        	 throw new SpeechletException("Invalid Intent");
        
        return response;
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
         log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    /**
     * Creates a {@code SpeechletResponse} for the intent.
     *
     * @param intent
     *            intent for the request
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse stockSpeechResponse(Intent intent) throws StockException {
    	String speechOutput = stockError;
    	
    	if(StockCompanyNameIntent.equals(intent.getName())) { //We matched a request for stock information by company name
    		log.info("Intent intent{}, CompanyNameSlot{} ", intent.getName(), intent.getSlot(CompanyNameSlot).getValue());
    		speechOutput = StockUtils.getStockInformation(intent.getSlot(CompanyNameSlot).getValue(), null);
    	} else if (StockSymbolNameIntent.equals(intent.getName())) { //We matched a request for stock information by symbol name
    		log.info("Intent intent{}, tickerSlot{} ", intent.getName(), intent.getSlot(SymbolSlot).getValue());
    		speechOutput = StockUtils.getStockInformation(null, StockUtils.formatSymbol(intent.getSlot(SymbolSlot).getValue()));
    	} else {
    		log.info("Unkown intent");
    		speechOutput = stockQuestionNotUnderstood;
    	}
    		
    	
    	log.info("Response: " + speechOutput);
        // Here we are setting shouldEndSession to true to end the session.
        return buildSpeechletResponse(intent.getName(), speechOutput, true);
    }

    /**
     * Creates and returns the visual and spoken response with shouldEndSession flag.
     *
     * @param title
     *            title for the companion application home card
     * @param output
     *            output content for speech and companion application home card
     * @param shouldEndSession
     *            should the session be closed
     * @return SpeechletResponse spoken and visual response for the given input
     */
    private SpeechletResponse buildSpeechletResponse(final String title, final String output,
            final boolean shouldEndSession) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle(String.format(appName + " - %s", title));
        card.setContent(String.format(appName + " - %s", output));

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(output);

        // Create the speechlet response.
        SpeechletResponse response = new SpeechletResponse();
        response.setShouldEndSession(shouldEndSession);
        response.setOutputSpeech(speech);
        response.setCard(card);
        return response;
    }
}
