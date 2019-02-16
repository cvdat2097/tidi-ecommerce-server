package org.springlab.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springlab.api.dto.response.AccountResponse;
import org.springlab.config.constant.ReturnCode;
import org.springlab.model.entity.Customer;
import org.springlab.model.repository.CustomerRepository;

@Service
public class AccountService {
    @Autowired
    private CustomerRepository customerRepo;

    public AccountResponse readCustomerInfo(String username) {
        Customer foundCustomer = customerRepo.findByUsername(username);

        if (foundCustomer == null) {
            return new AccountResponse(ReturnCode.FAILURE, "User not found");
        }

        return new AccountResponse(ReturnCode.SUCCESS, "User found", foundCustomer);
    }
}
