package org.springlab.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
    private ResponseStatus status;
    private String permission;
    private String token;

    // Constructors

    public AuthResponse() {
    }

    public AuthResponse(String permission, String token) {
        this.permission = permission;
        this.token = token;
    }

    public AuthResponse(Integer status, String message, String permission, String token) {
        this.status = new ResponseStatus(status, message);
        this.permission = permission;
        this.token = token;
    }

    // Getters & Setters

    public ResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
