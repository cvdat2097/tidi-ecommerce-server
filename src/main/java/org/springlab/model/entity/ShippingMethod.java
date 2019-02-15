package org.springlab.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_method")
public class ShippingMethod {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shipping_name")
    private String shippingName;

    @Column(name = "description")
    private String description;

    @Column(name = "shipping_fee")
    private String shippingFee;

    // Constructors
    public ShippingMethod() {
    }

    public ShippingMethod(Integer id, String shippingName, String description, String shippingFee) {
        this.id = id;
        this.shippingName = shippingName;
        this.description = description;
        this.shippingFee = shippingFee;
    }

    // Getters & Setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentName() {
        return this.shippingName;
    }

    public void setPaymentName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentFee() {
        return this.shippingFee;
    }

    public void setPaymentFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }
}
