package org.springlab.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springlab.model.entity.Branch;

public interface BranchRepository extends PagingAndSortingRepository<Branch, Integer>  {
}
