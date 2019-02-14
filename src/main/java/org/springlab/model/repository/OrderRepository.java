package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer>  {
}
