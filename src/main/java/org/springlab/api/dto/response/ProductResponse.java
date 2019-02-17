package org.springlab.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private ResponseStatus status;
    // Constructors

    public ProductResponse() {
    }

    public ProductResponse(ResponseStatus status) {
        this.status = status;
    }

    // Getters & Setters

    public ResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
}
