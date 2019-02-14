package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>  {
}
