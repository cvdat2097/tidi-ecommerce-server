package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.Brand;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer>  {
}
