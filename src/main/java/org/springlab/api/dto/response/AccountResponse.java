package org.springlab.api.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springlab.model.entity.Customer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
    private ResponseStatus status;
    private String email;
    private String fullName;
    private Date dateOfBirth;
    private String phone;
    private String gender;
    private String address;
    private String avatar;
    private String permission;

    // Constructors
    public AccountResponse() {
    }

    public AccountResponse(Integer returnCode, String returnMessage) {
        this.status = new ResponseStatus(returnCode, returnMessage);
    }

    public AccountResponse(Integer returnCode, String returnMessage, String email, String fullName, Date dateOfBirth, String phone,
            String gender, String address, String avatar, String permission) {
        this.status = new ResponseStatus(returnCode, returnMessage);
        this.email = email;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.avatar = avatar;
        this.permission = permission;
    }

    public AccountResponse(Integer returnCode, String returnMessage, Customer customer) {
        this.status = new ResponseStatus(returnCode, returnMessage);
        this.email = customer.getEmail();
        this.fullName = customer.getFullName();
        this.dateOfBirth = customer.getDateOfBirth();
        this.phone = customer.getPhone();
        this.gender = customer.getGender();
        this.address = customer.getAddress();
        this.avatar = customer.getAvatar();
        this.permission = customer.getPermission();
    }

    // Getters & Setters
    public ResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
