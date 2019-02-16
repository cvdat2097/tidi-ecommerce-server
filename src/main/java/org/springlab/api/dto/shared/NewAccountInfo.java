package org.springlab.api.dto.shared;

public class NewAccountInfo {
    private String dateOfBirth;
    private String address;
    private String avatar;

    // Constructors
    public NewAccountInfo() {
    }

    public NewAccountInfo(String dateOfBirth, String address, String avatar) {
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
    }

    // Getters & Setters

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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