package org.springlab.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springlab.api.dto.response.AuthResponse;
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
            return null;
        }

        final String tokenPermission = foundUser.getPermission();
        final String jwtToken = JWTService.generateToken(username, tokenPermission);
        return new AuthResponse(tokenPermission, jwtToken);
    }
}
