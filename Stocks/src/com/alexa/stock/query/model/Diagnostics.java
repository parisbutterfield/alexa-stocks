
package com.alexa.stock.query.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "cache",
    "url",
    "publiclyCallable",
    "query",
    "javascript",
    "user-time",
    "service-time",
    "build-version"
})

@JsonIgnoreProperties(ignoreUnknown=true)
public class Diagnostics {


    @JsonProperty("url")
    private List<Url> url = new ArrayList<Url>();
    @JsonProperty("publiclyCallable")
    private String publiclyCallable;
    @JsonProperty("query")
    private Query_ query;
    @JsonProperty("javascript")
    private Javascript javascript;
    @JsonProperty("user-time")
    private String userTime;
    @JsonProperty("service-time")
    private String serviceTime;
    @JsonProperty("build-version")
    private String buildVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public List<Url> getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(List<Url> url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The publiclyCallable
     */
    @JsonProperty("publiclyCallable")
    public String getPubliclyCallable() {
        return publiclyCallable;
    }

    /**
     * 
     * @param publiclyCallable
     *     The publiclyCallable
     */
    @JsonProperty("publiclyCallable")
    public void setPubliclyCallable(String publiclyCallable) {
        this.publiclyCallable = publiclyCallable;
    }

    /**
     * 
     * @return
     *     The query
     */
    @JsonProperty("query")
    public Query_ getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    @JsonProperty("query")
    public void setQuery(Query_ query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The javascript
     */
    @JsonProperty("javascript")
    public Javascript getJavascript() {
        return javascript;
    }

    /**
     * 
     * @param javascript
     *     The javascript
     */
    @JsonProperty("javascript")
    public void setJavascript(Javascript javascript) {
        this.javascript = javascript;
    }

    /**
     * 
     * @return
     *     The userTime
     */
    @JsonProperty("user-time")
    public String getUserTime() {
        return userTime;
    }

    /**
     * 
     * @param userTime
     *     The user-time
     */
    @JsonProperty("user-time")
    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    /**
     * 
     * @return
     *     The serviceTime
     */
    @JsonProperty("service-time")
    public String getServiceTime() {
        return serviceTime;
    }

    /**
     * 
     * @param serviceTime
     *     The service-time
     */
    @JsonProperty("service-time")
    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    /**
     * 
     * @return
     *     The buildVersion
     */
    @JsonProperty("build-version")
    public String getBuildVersion() {
        return buildVersion;
    }

    /**
     * 
     * @param buildVersion
     *     The build-version
     */
    @JsonProperty("build-version")
    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
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
