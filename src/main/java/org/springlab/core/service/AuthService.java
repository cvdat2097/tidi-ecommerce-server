package org.springlab.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springlab.api.dto.response.AuthResponse;
import org.springlab.api.dto.response.ResponseStatus;
import org.springlab.config.constant.ReturnCode;
import org.springlab.config.constant.ReturnMessage;
import org.springlab.core.guard.JWTService;
import org.springlab.model.entity.Customer;
import org.springlab.model.repository.CustomerRepository;

@Service
public class AuthService {
    @Autowired
    private CustomerRepository customerRepo;

    public AuthResponse login(String username, String password) {
        Customer foundUser = customerRepo.findByUsername(username);
        if (foundUser == null || foundUser.getPassword().equals(password) == false) {
            return new AuthResponse(ReturnCode.FAILURE, ReturnMessage.LOGIN_FAILURE, null, null);
        }

        final String tokenPermission = foundUser.getPermission();
        final String jwtToken = JWTService.generateToken(username, tokenPermission);
        return new AuthResponse(ReturnCode.SUCCESS, ReturnMessage.LOGIN_SUCCESS, tokenPermission, jwtToken);
    }

    public AuthResponse register(Customer newCustomer) throws Exception{
        // Find existing info
        Customer exitsingCustomer = customerRepo.findExisting(newCustomer.getUsername(), newCustomer.getEmail(), newCustomer.getPhone());
        if (exitsingCustomer != null) {
            if (newCustomer.getUsername().equals(exitsingCustomer.getUsername())) {
                throw new Exception("username is existing");
            }
            if (newCustomer.getEmail().equals(exitsingCustomer.getEmail())) {
                throw new Exception("email is existing");
            }
            if (newCustomer.getPhone().equals(exitsingCustomer.getPhone())) {
                throw new Exception("phone number is existing");
            }
        }
        
        // Save to db
        try {
            customerRepo.save(newCustomer);

            AuthResponse res = this.login(newCustomer.getUsername(), newCustomer.getPassword());
            res.setStatus(new ResponseStatus(res.getStatus().getStatus(), ReturnMessage.REGISTER_SUCCESS));

            return res;
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return new AuthResponse(ReturnCode.FAILURE, "Can't register new customer", null, null);
    }

    public AuthResponse verifyToken(String jwtToken) {
        if (JWTService.isValidToken(jwtToken) == false) {
            return new AuthResponse(ReturnCode.FAILURE, "Token is invalid", null, null);
        }

        return new AuthResponse(ReturnCode.SUCCESS, "Token is valid", null, null);
    }
}
