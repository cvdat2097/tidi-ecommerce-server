package org.springlab.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springlab.api.dto.request.AuthRequest;
import org.springlab.api.dto.response.AuthResponse;
import org.springlab.api.routes.RouteAuthentication;
import org.springlab.config.constant.Constant;
import org.springlab.config.constant.ReturnCode;
import org.springlab.core.service.AccountService;
import org.springlab.model.entity.Customer;

@RestController
@RequestMapping(Constant.baseURL + RouteAuthentication.ROOT)
public class AuthController {

    @Autowired
    private AccountService accountService;

    @PostMapping(RouteAuthentication.LOGIN)
    public AuthResponse loginHandler(@RequestBody AuthRequest req) {
        // Validation
        final String username = req.getUsername();
        final String password = req.getPassword();

        if (username == null || username.isEmpty()) {
            return new AuthResponse(ReturnCode.FAILURE, "username is empty", null, null);
        }
        if (password == null || password.isEmpty()) {
            return new AuthResponse(ReturnCode.FAILURE, "password is empty", null, null);
        }

        // Login
        AuthResponse res = accountService.login(username, password);

        return res;
    }

    @PostMapping(RouteAuthentication.REGISTER)
    public AuthResponse registerHandler(@RequestBody AuthRequest req) {
        // Validation
        if (req.getUsername() == null || req.getUsername().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "username is missing", null, null);
        }

        if (req.getPassword() == null || req.getPassword().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "password is missing", null, null);
        }

        if (req.getEmail() == null || req.getEmail().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "email is missing", null, null);
        }

        if (req.getPhone() == null || req.getPhone().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "phone number is missing", null, null);
        }

        if (req.getPermission() == null) {
            req.setPermission(Customer.getDefaultPermission());
        }

        SimpleDateFormat dateFormatter = new SimpleDateFormat(Constant.DATE_FORMAT);
        Date customerDOB;
        try {
            customerDOB = dateFormatter.parse(req.getDateOfBirth());
            if (customerDOB == null) {
                throw new ParseException("DOB is null", 1);
            }
        } catch (ParseException exc) {
            exc.printStackTrace();
            return new AuthResponse(ReturnCode.FAILURE, "DOB is in wrong format", null, null);
        }

        // Register new customer
        Customer newCustomer = new Customer(req.getUsername(), req.getPassword(), req.getPermission(),
                req.getFullName(), customerDOB, req.getGender(), req.getPhone(), req.getEmail(), req.getAddress(),
                req.getAvatar());
        AuthResponse res;
        try {
            res = accountService.register(newCustomer);
        } catch (Exception exc) {
            return new AuthResponse(ReturnCode.FAILURE, exc.getMessage(), null, null);
        }

        return res;
    }
}
