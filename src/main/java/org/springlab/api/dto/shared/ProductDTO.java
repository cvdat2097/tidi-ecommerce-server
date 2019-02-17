package org.springlab.api.dto.shared;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springlab.api.dto.response.ResponseStatus;
import org.springlab.model.entity.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private ResponseStatus status;
    private Integer id;
    private String productName;
    private Integer price;
    private Integer amount;
    private Brand brand;
    private Industry industry;
    private Branch branch;
    private Category category;
    private String description;
    private String images;
    private Float discPercent;
    private Boolean active;

    // Constructors
    public ProductDTO() {
    }

    public ProductDTO(Integer returnCode, String returnMessage) {
        this.status = new ResponseStatus(returnCode, returnMessage);
    }

    public ProductDTO(Integer id, String productName, Integer price, Integer quantity, Brand brand, Industry industry, Branch branch, Category category, String description, String images, Boolean active) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.amount = quantity;
        this.brand = brand;
        this.industry = industry;
        this.branch = branch;
        this.category = category;
        this.description = description;
        this.images = images;
        this.active = active;
    }

    public ProductDTO(Integer returnCode, String returnMessage, Product product) {
        this.status = new ResponseStatus(returnCode, returnMessage);
        this.id = product.getId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.amount = product.getQuantity();
        this.brand = product.getBrand();
        this.industry = product.getIndustry();
        this.branch = product.getBranch();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.images = product.getImages();
        this.active = product.getActive();
    }

    // Getters & Setters

    public ResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Industry getIndustry() {
        return this.industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return this.images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean isActive() {
        return this.active;
    }

    public Float getDiscPercent() {
        return this.discPercent;
    }

    public void setDiscPercent(Float discPercent) {
        this.discPercent = discPercent;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}