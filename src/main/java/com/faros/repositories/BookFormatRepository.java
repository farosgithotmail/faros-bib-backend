package com.faros.repositories;

import com.faros.domain.BookFormat;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface BookFormatRepository extends PagingAndSortingRepository<BookFormat, Long> {
}
