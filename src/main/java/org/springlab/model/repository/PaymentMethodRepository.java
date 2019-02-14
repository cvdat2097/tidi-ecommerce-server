package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.PaymentMethod;

public interface PaymentMethodRepository extends PagingAndSortingRepository<PaymentMethod, Integer>  {
}
