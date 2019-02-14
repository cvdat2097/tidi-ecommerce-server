package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.OrderDetail;

public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Integer>  {
}
