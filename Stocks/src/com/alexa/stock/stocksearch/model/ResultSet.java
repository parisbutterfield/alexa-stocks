package com.alexa.stock.stocksearch.model;


import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultSet {
private List<Result> result;


public List<Result> getResult() {
    return this.result;
}

@JsonProperty("Result")
public void setResult(List<Result> result) {
    this.result = result;
}
}
