package org.springlab.api.dto.request;

import org.springlab.api.dto.shared.NewAccountInfo;

public class AccountRequest {

    private NewAccountInfo newInfo;
    private String password;
    private String newPassword;

    // Constructors
    public AccountRequest() {
    }

    public AccountRequest(NewAccountInfo newInfo, String password, String newPassword) {
        this.newInfo = newInfo;
        this.password = password;
        this.newPassword = newPassword;
    }

    // Getters & Setters
    public NewAccountInfo getNewInfo() {
        return this.newInfo;
    }

    public void setNewInfo(NewAccountInfo newInfo) {
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
