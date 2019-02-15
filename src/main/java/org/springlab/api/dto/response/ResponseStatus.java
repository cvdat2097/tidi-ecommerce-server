package org.springlab.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseStatus {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Integer status;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String message;

    // Constructors

    public ResponseStatus() {
    }

    public ResponseStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters & Setters

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
