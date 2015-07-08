package com.alexa.stock.main;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

/***
 * 
 * @author parisbutterfield
 *
 */
public class StockServlet extends SpeechletServlet {

	  public StockServlet() {
		    this.setSpeechlet(new StockSpeechlet());
		  }
}
