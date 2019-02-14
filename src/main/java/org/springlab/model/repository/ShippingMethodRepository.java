package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.ShippingMethod;

public interface ShippingMethodRepository extends PagingAndSortingRepository<ShippingMethod, Integer>  {
}
