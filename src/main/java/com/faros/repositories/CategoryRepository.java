package com.faros.repositories;

import com.faros.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
