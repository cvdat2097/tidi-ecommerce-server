package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>  {
}
