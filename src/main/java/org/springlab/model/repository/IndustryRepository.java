package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.Industry;

public interface IndustryRepository extends PagingAndSortingRepository<Industry, Integer>  {
}
