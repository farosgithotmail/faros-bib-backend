package com.faros.domain;

import com.faros.domain.enums.Language;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Data
@Document(collection = "books")
public class Book {
    @Id
    private ObjectId id;
    private String isbn10;
    private String isbn13;
    private String title;
    @Reference
    private Set<Author> authors = new HashSet<>();
    private Language language;
    private int pages;
    @Reference
    private Set<Category> categories = new HashSet<>();
    private Set<String> keywords = new HashSet<>();
    private LocalDate releaseDate;
    private int edition;
    @Reference
    private BookType type;
    @Reference
    private BookFormat format;
    private String summary;
    private Set<String> images = new HashSet<>();

}
