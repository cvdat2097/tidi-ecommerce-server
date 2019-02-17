package org.springlab.api.dto.request;

import org.springlab.api.dto.shared.RequestQuery;

public class ProductRequest {
    private RequestQuery query;
    private Long limit;
    private Long offset;

    // Constructors

    public ProductRequest() {
    }

    public ProductRequest(RequestQuery query, Long limit, Long offset) {
        this.query = query;
        this.limit = limit;
        this.offset = offset;
    }

    // Getters & Setters

    public RequestQuery getQuery() {
        return this.query;
    }

    public void setQuery(RequestQuery query) {
        this.query = query;
    }

    public Long getLimit() {
        return this.limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return this.offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

}
