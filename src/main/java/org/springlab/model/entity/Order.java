package org.springlab.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "total")
    private Long total;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private PaymentMethod shippingMethod;

    @Column(name = "zalopay_token")
    private String zalopayToken;

    @Column(name = "zalopay_transid")
    private String zalopayTransid;

    @Column(name = "app_transid")
    private String appTransid;

    // Constructors
    public Order() {
    }

    public Order(Integer id, Customer customer, String fullName, String phone, String email, String address, Long total, String orderStatus, String note, PaymentMethod paymentMethod, PaymentMethod shippingMethod, String zalopayToken, String zalopayTransid, String appTransid) {
        this.id = id;
        this.customer = customer;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.total = total;
        this.orderStatus = orderStatus;
        this.note = note;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.zalopayToken = zalopayToken;
        this.zalopayTransid = zalopayTransid;
        this.appTransid = appTransid;
    }

    // Getters & Setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(PaymentMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getZalopayToken() {
        return this.zalopayToken;
    }

    public void setZalopayToken(String zalopayToken) {
        this.zalopayToken = zalopayToken;
    }

    public String getZalopayTransid() {
        return this.zalopayTransid;
    }

    public void setZalopayTransid(String zalopayTransid) {
        this.zalopayTransid = zalopayTransid;
    }

    public String getAppTransid() {
        return this.appTransid;
    }

    public void setAppTransid(String appTransid) {
        this.appTransid = appTransid;
    }
}
