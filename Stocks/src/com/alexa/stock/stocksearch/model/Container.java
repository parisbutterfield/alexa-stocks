package com.alexa.stock.stocksearch.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Container {
	ResultSet resultSet;

	public ResultSet getResultSet() {
		return resultSet;
	}

	@JsonProperty("ResultSet")
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	

}
