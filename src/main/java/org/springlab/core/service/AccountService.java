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
public class AccountService {
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

    public AuthResponse register(Customer newCustomer) {
        // Validation
        if (newCustomer.getUsername() == null || newCustomer.getUsername().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "username is missing", null, null);
        }

        if (newCustomer.getPassword() == null || newCustomer.getPassword().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "password is missing", null, null);
        }

        if (newCustomer.getEmail() == null || newCustomer.getEmail().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "email is missing", null, null);
        }

        if (newCustomer.getPhone() == null || newCustomer.getPhone().length() == 0) {
            return new AuthResponse(ReturnCode.FAILURE, "phone number is missing", null, null);
        }

        if (newCustomer.getPermission() == null) {
            newCustomer.setPermission(Customer.getDefaultPermission());
        }

        Customer exitsingCustomer = customerRepo.findExisting(newCustomer.getUsername(), newCustomer.getEmail(),
                newCustomer.getPhone());

        if (exitsingCustomer != null) {
            if (newCustomer.getUsername().equals(exitsingCustomer.getUsername())) {
                return new AuthResponse(ReturnCode.FAILURE, "username is existing", null, null);
            }
            if (newCustomer.getEmail().equals(exitsingCustomer.getEmail())) {
                return new AuthResponse(ReturnCode.FAILURE, "email is existing", null, null);
            }
            if (newCustomer.getPhone().equals(exitsingCustomer.getPhone())) {
                return new AuthResponse(ReturnCode.FAILURE, "phone is existing", null, null);
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
}
