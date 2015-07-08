
package com.alexa.stock.query.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "execution-start-time",
    "execution-stop-time",
    "execution-time",
    "content"
})

@JsonIgnoreProperties(ignoreUnknown=true)
public class Url {
	
	
    @JsonProperty("execution-start-time")
    private String executionStartTime;
    @JsonProperty("execution-stop-time")
    private String executionStopTime;
    @JsonProperty("execution-time")
    private String executionTime;
    @JsonProperty("content")
    private String content;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The executionStartTime
     */
    @JsonProperty("execution-start-time")
    public String getExecutionStartTime() {
        return executionStartTime;
    }

    /**
     * 
     * @param executionStartTime
     *     The execution-start-time
     */
    @JsonProperty("execution-start-time")
    public void setExecutionStartTime(String executionStartTime) {
        this.executionStartTime = executionStartTime;
    }

    /**
     * 
     * @return
     *     The executionStopTime
     */
    @JsonProperty("execution-stop-time")
    public String getExecutionStopTime() {
        return executionStopTime;
    }

    /**
     * 
     * @param executionStopTime
     *     The execution-stop-time
     */
    @JsonProperty("execution-stop-time")
    public void setExecutionStopTime(String executionStopTime) {
        this.executionStopTime = executionStopTime;
    }

    /**
     * 
     * @return
     *     The executionTime
     */
    @JsonProperty("execution-time")
    public String getExecutionTime() {
        return executionTime;
    }

    /**
     * 
     * @param executionTime
     *     The execution-time
     */
    @JsonProperty("execution-time")
    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    /**
     * 
     * @return
     *     The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
