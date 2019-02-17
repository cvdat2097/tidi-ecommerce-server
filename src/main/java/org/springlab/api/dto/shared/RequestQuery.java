package org.springlab.api.dto.shared;

public class RequestQuery {
    private String industryId;
    private String brandId;
    private String branchId;
    private String categoryId;
    private String keyword;
    private Long minPrice;
    private Long maxPrice;

    // Constructors

    public RequestQuery() {
    }

    public RequestQuery(String industryId, String brandId, String branchId, String categoryId, String keyword, Long minPrice, Long maxPrice) {
        this.industryId = industryId;
        this.brandId = brandId;
        this.branchId = branchId;
        this.categoryId = categoryId;
        this.keyword = keyword;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    // Getters & Setters

    public String getIndustryId() {
        return this.industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getBrandId() {
        return this.brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getMinPrice() {
        return this.minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getMaxPrice() {
        return this.maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

}
