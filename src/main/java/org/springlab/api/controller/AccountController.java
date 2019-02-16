package org.springlab.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springlab.config.constant.Constant;
import org.springlab.config.constant.ReturnCode;
import org.springlab.core.guard.JWTService;
import org.springlab.core.service.AccountService;
import org.springlab.api.dto.response.AccountResponse;
import org.springlab.api.routes.RouteAccount;

@RestController
@RequestMapping(Constant.BASE_URL + RouteAccount.ROOT)
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping(RouteAccount.INFO)
    private AccountResponse getAccountInfoHandler(@RequestHeader(value = "Authorization") String jwtToken) {
        if (JWTService.isValidToken(jwtToken)) {
            try {
                final String username = JWTService.getDecodedToken(jwtToken).getClaim("username").asString();

                return accountService.readCustomerInfo(username);

            } catch (Exception exc) {
                exc.printStackTrace();
                return new AccountResponse(ReturnCode.FAILURE, "Can not read account info");
            }
        }

        return new AccountResponse(ReturnCode.FAILURE, "token is invalid");
    }
}
