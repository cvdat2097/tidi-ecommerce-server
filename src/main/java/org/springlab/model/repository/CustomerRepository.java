package org.springlab.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springlab.model.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>  {
    public Customer findByUsername(String username);
}
