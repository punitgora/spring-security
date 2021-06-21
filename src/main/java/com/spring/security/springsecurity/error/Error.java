package com.spring.security.springsecurity.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"name", "message", "information_link"})
public class Error {
    @JsonProperty("name")
    private String name;
    @JsonProperty("message")
    private String message;
    @JsonProperty("informational_link")
    private String informationLink;

    public Error() {

    }
    public Error(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Error(String name, String message, String informationLink) {
        this.name = name;
        this.message = message;
        this.informationLink = informationLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInformationLink() {
        return informationLink;
    }

    public void setInformationLink(String informationLink) {
        this.informationLink = informationLink;
    }
}
