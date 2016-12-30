package com.faros.repositories;

import com.faros.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    @RestResource(path = "by-title", rel = "by-title")
    Page<Book> findDistinctByTitleContainingIgnoreCase(@Param("title") String title, Pageable pageable);

    @RestResource(path = "by-author", rel = "by-author")
    Page<Book> findDistinctByAuthorsNameContainingIgnoreCase(@Param(value = "name") String name, Pageable pageable);

    @RestResource(path = "by-type", rel = "by-type")
    Page<Book> findDistinctByTypeNameContainingIgnoreCase(@Param(value = "name") String name, Pageable pageable);

    @RestResource(path = "by-format", rel = "by-format")
    Page<Book> findDistinctByFormatNameContainingIgnoreCase(@Param(value = "name") String name, Pageable pageable);

    @RestResource(path = "by-keyword", rel = "by-keyword")
    Page<Book> findDistinctByKeywordsContainingIgnoreCase(@Param(value = "keywords") String keywords, Pageable pageable);

    @RestResource(path = "by-whatever", rel = "by-whatever")
    @Query("SELECT DISTINCT book FROM Book book " +
            " LEFT JOIN book.authors author" +
            " LEFT JOIN book.type type" +
            " LEFT JOIN book.format format" +
            " LEFT JOIN book.categories category" +
            " LEFT JOIN book.keywords keyword" +
            " WHERE UPPER(book.title) LIKE UPPER(CONCAT('%',:whatever,'%')) " +
            " OR UPPER(book.isbn10) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(book.isbn13) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(book.summary) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(author.name) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(type.name) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(format.name) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(keyword) LIKE UPPER(CONCAT('%',:whatever,'%'))" +
            " OR UPPER(category.name) LIKE UPPER(CONCAT('%',:whatever,'%'))"
    )
    Page<Book> findByWhateverIgnoreCase(@Param(value = "whatever") String whatever, Pageable pageable);
}
