package com.faros.repositories;

import com.faros.domain.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

}
