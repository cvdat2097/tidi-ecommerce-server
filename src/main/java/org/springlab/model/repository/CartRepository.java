package org.springlab.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springlab.model.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>  {
}
