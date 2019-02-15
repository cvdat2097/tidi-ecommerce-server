package org.springlab.api.controller;

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
import org.springlab.core.service.AccountService;
import org.springlab.model.entity.Customer;

@RestController
@RequestMapping(Constant.baseURL + RouteAuthentication.ROOT)
public class AuthController {

    @Autowired
    private AccountService accountService;

    @PostMapping(RouteAuthentication.LOGIN)
    public AuthResponse loginHandler(@RequestBody AuthRequest req) {
        AuthResponse res = accountService.login(req.getUsername(), req.getPassword());

        return res;
    }

    @PostMapping(RouteAuthentication.REGISTER)
    public AuthResponse registerHandler(@RequestBody AuthRequest req) {

        // TODO: format date of birth
        Customer newCustomer = new Customer(req.getUsername(), req.getPassword(), req.getPermission(),
                req.getFullName(), new Date(), req.getGender(), req.getPhone(), req.getEmail(), req.getAddress(),
                req.getAvatar());

        AuthResponse res = accountService.register(newCustomer);

        return res;
    }
}
