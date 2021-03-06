
package com.alexa.stock.query.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "execution-start-time",
    "execution-stop-time",
    "execution-time",
    "instructions-used",
    "table-name"
})

@JsonIgnoreProperties(ignoreUnknown=true)
public class Javascript {

    @JsonProperty("execution-start-time")
    private String executionStartTime;
    @JsonProperty("execution-stop-time")
    private String executionStopTime;
    @JsonProperty("execution-time")
    private String executionTime;
    @JsonProperty("instructions-used")
    private String instructionsUsed;
    @JsonProperty("table-name")
    private String tableName;
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
     *     The instructionsUsed
     */
    @JsonProperty("instructions-used")
    public String getInstructionsUsed() {
        return instructionsUsed;
    }

    /**
     * 
     * @param instructionsUsed
     *     The instructions-used
     */
    @JsonProperty("instructions-used")
    public void setInstructionsUsed(String instructionsUsed) {
        this.instructionsUsed = instructionsUsed;
    }

    /**
     * 
     * @return
     *     The tableName
     */
    @JsonProperty("table-name")
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * @param tableName
     *     The table-name
     */
    @JsonProperty("table-name")
    public void setTableName(String tableName) {
        this.tableName = tableName;
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
