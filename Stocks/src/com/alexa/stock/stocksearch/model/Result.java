package com.alexa.stock.stocksearch.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Result {

	String symbol;
	String name;
	String exchDisp;
	String exch;
	String typeDisp;
	String type;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
    public void setName(String name) {
		this.name = name;
	}
	public String getExchDisp() {
		return exchDisp;
	}
	
	@JsonProperty("exchDisp")
	public void setExchDisp(String exchDisp) {
		this.exchDisp = exchDisp;
	}
	public String getExch() {
		return exch;
	}
	
	@JsonProperty("exch")
    public void setExch(String exch) {
		this.exch = exch;
	}
	public String getTypeDisp() {
		return typeDisp;
	}
	
	@JsonProperty("typeDisp")
    public void setTypeDisp(String typeDisp) {
		this.typeDisp = typeDisp;
	}
	public String getType() {
		return type;
	}
	
	@JsonProperty("type")
    public void setType(String type) {
		this.type = type;
	}
	
	
	
}
