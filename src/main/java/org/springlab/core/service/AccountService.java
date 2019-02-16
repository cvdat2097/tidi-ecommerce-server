package org.springlab.core.service;

import java.util.Date;

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

    public AccountResponse updateCustomerInfo(String username, Date dateOfBirth, String address, String avatar) {
        Customer foundCustomer = customerRepo.findByUsername(username);

        if (foundCustomer == null) {
            return new AccountResponse(ReturnCode.FAILURE, "User not found");
        }

        if (dateOfBirth != null) {
            foundCustomer.setDateOfBirth(dateOfBirth);
        }

        if (address != null) {
            foundCustomer.setAddress(address);
        }

        if (avatar != null) {
            foundCustomer.setAddress(avatar);
        }

        customerRepo.save(foundCustomer);

        return new AccountResponse(ReturnCode.SUCCESS, "Customer info is updated successfully");
    }

    public AccountResponse updatePassword(String username, String oldPassword, String newPassword) {
        Customer foundCustomer = customerRepo.findByUsername(username);

        if (foundCustomer == null) {
            return new AccountResponse(ReturnCode.FAILURE, "User not found");
        }

        if (oldPassword.compareTo(foundCustomer.getPassword()) == 0) {
            foundCustomer.setPassword(newPassword);

            customerRepo.save(foundCustomer);
            return new AccountResponse(ReturnCode.SUCCESS, "Customer password is updated successfully");
        } else {
            return new AccountResponse(ReturnCode.FAILURE, "Old password is incorrect");
        }
    }
}
