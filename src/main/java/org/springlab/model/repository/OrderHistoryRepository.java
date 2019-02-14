package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.OrderHistory;

public interface OrderHistoryRepository extends PagingAndSortingRepository<OrderHistory, Integer>  {
}
