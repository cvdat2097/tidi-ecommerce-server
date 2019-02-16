package org.springlab.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springlab.config.constant.Constant;
import org.springlab.config.constant.ReturnCode;
import org.springlab.core.guard.JWTService;
import org.springlab.core.service.AccountService;
import org.springlab.helper.HelperFunc;
import org.springlab.api.dto.request.AccountRequest;
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

    @PostMapping(RouteAccount.UPDATE_INFO)
    private AccountResponse updateAccountInfoHandler(@RequestBody AccountRequest req,
            @RequestHeader(value = "Authorization") String jwtToken) {
        if (JWTService.isValidToken(jwtToken)) {
            try {
                final String username = JWTService.getDecodedToken(jwtToken).getClaim("username").asString();

                final String newAddress = req.getNewInfo().getAddress();
                final String newAvatar = req.getNewInfo().getAddress();
                final Date newDateOfBirth = HelperFunc.getFormartedDate(req.getNewInfo().getDateOfBirth());

                if ((newAddress == null || newAddress.isEmpty()) && (newAvatar == null || newAvatar.isEmpty())
                        && newDateOfBirth == null) {
                    return new AccountResponse(ReturnCode.FAILURE, "New info can't be empty");
                }

                return accountService.updateCustomerInfo(username, newDateOfBirth, newAddress, newAvatar);

            } catch (Exception exc) {
                exc.printStackTrace();
                return new AccountResponse(ReturnCode.FAILURE, "Can not read account info");
            }
        }

        return new AccountResponse(ReturnCode.FAILURE, "token is invalid");
    }

    @PostMapping(RouteAccount.UPDATE_PASSWORD)
    private AccountResponse updatePasswordHandler(@RequestBody AccountRequest req,
            @RequestHeader(value = "Authorization") String jwtToken) {
        if (JWTService.isValidToken(jwtToken)) {
            try {
                final String username = JWTService.getDecodedToken(jwtToken).getClaim("username").asString();

                final String oldPassword = req.getPassword();
                final String newPassword = req.getNewPassword();

                if (oldPassword == null || oldPassword.isEmpty()) {
                    return new AccountResponse(ReturnCode.FAILURE, "Old password is missing");
                }

                if (newPassword == null || newPassword.isEmpty()) {
                    return new AccountResponse(ReturnCode.FAILURE, "New password is missing");
                }

                return accountService.updatePassword(username, oldPassword, newPassword);
            } catch (Exception exc) {
                exc.printStackTrace();
                return new AccountResponse(ReturnCode.FAILURE, "Can not read account info");
            }
        }

        return new AccountResponse(ReturnCode.FAILURE, "token is invalid");
    }
}
