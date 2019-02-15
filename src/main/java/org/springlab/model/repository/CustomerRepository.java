package org.springlab.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springlab.model.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer findByUsername(String username);

    @Query("SELECT c FROM Customer c WHERE :username = c.username OR :email = c.email OR :phone = c.phone")
    public Customer findExisting(@Param("username") String username, @Param("email") String email,
            @Param("phone") String phone);
}
