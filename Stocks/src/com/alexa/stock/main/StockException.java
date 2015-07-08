package com.alexa.stock.main;


/***
 * 
 * @author parisbutterfield
 *
 */
public class StockException extends Exception {
	String exception;
	
	public StockException(String exception){
		 this.exception = exception;
		
	}
	
	
	public String toString() {
		return exception;
	}

}
