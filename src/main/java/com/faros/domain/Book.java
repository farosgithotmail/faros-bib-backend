package com.faros.domain;

import com.faros.domain.enums.Language;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn10;
    private String isbn13;
    private String title;
    @ManyToMany
    private Set<Author> authors;
    @Enumerated(EnumType.STRING)
    private Language language;
    private int pages;
    @ManyToMany
    private Set<Category> categories;
    @ElementCollection
    private Set<String> keywords;
    private LocalDate releaseDate;
    private int edition;
    @ManyToOne
    private BookType type;
    @ManyToOne
    private BookFormat format;
    private String summary;
    @ElementCollection
    private Set<String> images;

    public Book(){
        this.authors = new HashSet<>();
        this.categories = new HashSet<>();
        this.keywords = new HashSet<>();
        this.images = new HashSet<>();
    }
}
