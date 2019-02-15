package org.springlab.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "payment_name")
    private String paymentName;

    @Column(name = "description")
    private String description;

    @Column(name = "payment_fee")
    private String paymentFee;

    // Constructors
    public PaymentMethod() {
    }

    public PaymentMethod(Integer id, String paymentName, String description, String paymentFee) {
        this.id = id;
        this.paymentName = paymentName;
        this.description = description;
        this.paymentFee = paymentFee;
    }

    // Getters & Setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentName() {
        return this.paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentFee() {
        return this.paymentFee;
    }

    public void setPaymentFee(String paymentFee) {
        this.paymentFee = paymentFee;
    }
}
