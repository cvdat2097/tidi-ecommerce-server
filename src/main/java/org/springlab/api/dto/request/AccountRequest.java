package org.springlab.api.dto.request;

import java.util.Date;

public class AccountRequest {
    private AccountInfo newInfo;
    private String password;
    private String newPassword;

    // Constructors
    public AccountRequest() {
    }

    public AccountRequest(AccountInfo newInfo, String password, String newPassword) {
        this.newInfo = newInfo;
        this.password = password;
        this.newPassword = newPassword;
    }

    // Getters & Setters
    public AccountInfo getNewInfo() {
        return this.newInfo;
    }

    public void setNewInfo(AccountInfo newInfo) {
        this.newInfo = newInfo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}

class AccountInfo {
    private Date dateOfBirth;
    private String address;
    private String avatar;

    // Constructors
    public AccountInfo() {
    }

    public AccountInfo(Date dateOfBirth, String address, String avatar) {
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
    }

    // Getters & Setters

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

}
