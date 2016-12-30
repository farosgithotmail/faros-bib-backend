package com.faros.repositories;

import com.faros.domain.BookType;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface BookTypeRepository extends PagingAndSortingRepository<BookType, Long> {
}
