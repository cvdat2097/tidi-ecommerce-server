package org.springlab.api.controller;

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
import org.springlab.config.constant.ReturnMessage;
import org.springlab.core.service.AccountService;

@RestController
@RequestMapping(Constant.baseURL + RouteAuthentication.ROOT)
public class AuthController {

    @Autowired
    private AccountService accountService;

    @PostMapping(RouteAuthentication.LOGIN)
    public AuthResponse loginHandler(@RequestBody(required = false) AuthRequest req) {
        AuthResponse res = accountService.login(req.getUsername(), req.getPassword());

        if (res == null) {
            return new AuthResponse(ReturnCode.FAILURE, ReturnMessage.LOGIN_FAILURE, null, null);
        }

        return new AuthResponse(ReturnCode.SUCCESS, ReturnMessage.LOGIN_SUCCESS, res.getPermission(), res.getToken());
    }

    // @GetMapping(name = RouteAuthentication.REGISTER)
    // public String registerHandler(){
    // return "Hello this is rest";
    // }

    // @GetMapping(name = RouteAuthentication.EMAIL_VERIFICATION)
    // public String emailVerificationHandler(){
    // return "Hello this is rest";
    // }

    // @GetMapping(name = RouteAuthentication.RESET_PASSWORD)
    // public String resetPasswordHandler(){
    // return "Hello this is rest";
    // }

    // @GetMapping(name = RouteAuthentication.RESET_EMAIL_VERIFICATION)
    // public String resetEmailVerificationHandler(){
    // return "Hello this is rest";
    // }

    // @GetMapping(name = RouteAuthentication.VERIFY_TOKEN)
    // public String verifyTokenHandler(){
    // return "Hello this is rest";
    // }
}
