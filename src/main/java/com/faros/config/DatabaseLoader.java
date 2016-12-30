package com.faros.config;

import com.faros.domain.*;
import com.faros.domain.enums.Language;
import com.faros.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookTypeRepository bookTypeRepository;
    private final BookFormatRepository bookFormatRepository;

    @Autowired
    public DatabaseLoader(AuthorRepository authorRepository, BookRepository bookRepository, CategoryRepository categoryRepository,
                          BookTypeRepository bookTypeRepository, BookFormatRepository bookFormatRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.bookTypeRepository = bookTypeRepository;
        this.bookFormatRepository = bookFormatRepository;

    }

    @Override
    public void run(String... strings) throws Exception {
        authorRepository.deleteAll();
        bookRepository.deleteAll();
        categoryRepository.deleteAll();
        bookTypeRepository.deleteAll();
        bookFormatRepository.deleteAll();

        Author author1 = new Author();
        author1.setName("Dimitri Juchtmans");

        Author author2 = new Author();
        author2.setName("Jeroen Sterken");

        Author author3 = new Author();
        author3.setName("Johan Vlaeyen");

        author1 = authorRepository.save(author1);
        author2 = authorRepository.save(author2);
        author3 = authorRepository.save(author3);

        Category category1 = new Category();
        category1.setName("Fantasy");

        Category category2 = new Category();
        category2.setName("Horror");

        Category category3 = new Category();
        category3.setName("Science fiction");

        categoryRepository.save(Arrays.asList(category1, category2, category3));

        BookType type = new BookType();
        type.setName("a type");

        bookTypeRepository.save(type);

        BookFormat format = new BookFormat();
        format.setName("a format");

        bookFormatRepository.save(format);

        Book book1 = new Book();
        book1.setIsbn10("1234567890");
        book1.setIsbn13("1234567891234");
        book1.setTitle("How to be happy with Faros");
        book1.setLanguage(Language.NL);
        book1.setPages(50);
        book1.getKeywords().addAll(Arrays.asList("funny", "lol"));
        book1.setReleaseDate(LocalDate.now());
        book1.setEdition(1);
        book1.setSummary("This is a summary");
        book1.getAuthors().addAll(Arrays.asList(author2, author3));
        book1.getCategories().add(category1);
        book1.setFormat(format);
        book1.setType(type);
        book1.setImages(new HashSet<>(Arrays.asList("funny.jpg", "lol.jpg")));

        Book book2 = new Book();
        book2.setIsbn10("0123456789");
        book2.setIsbn13("9876543219876");
        book2.setTitle("How to play Poker");
        book2.setLanguage(Language.EN);
        book2.setPages(200);
        book2.getKeywords().addAll(Arrays.asList("poker", "holdem"));
        book2.setReleaseDate(LocalDate.now());
        book2.setEdition(1);
        book2.setSummary("This is a summary");
        book2.getAuthors().addAll(Arrays.asList(author1));
        book2.getCategories().add(category1);
        book2.setFormat(format);
        book2.setType(type);
        book2.setImages(new HashSet<>(Arrays.asList("card.jpg", "ace.jpg")));

        Book book3 = new Book();
        book3.setIsbn10("0123456788");
        book3.setIsbn13("9876543219877");
        book3.setTitle("How to play Poker Part 2");
        book3.setLanguage(Language.EN);
        book3.setPages(200);
        book3.getKeywords().addAll(Arrays.asList("poker", "holdem"));
        book3.setReleaseDate(LocalDate.now());
        book3.setEdition(1);
        book3.setSummary("This is a summary");
        book3.getAuthors().addAll(Arrays.asList(author1));
        book3.getCategories().add(category1);
        book3.setFormat(format);
        book3.setType(type);
        book3.setImages(new HashSet<>(Arrays.asList("card.jpg", "ace.jpg")));

        Book book4 = new Book();
        book4.setIsbn10("5555555555");
        book4.setIsbn13("1313131313131");
        book4.setTitle("How to play Poker Part 3");
        book4.setLanguage(Language.EN);
        book4.setPages(200);
        book4.getKeywords().addAll(Arrays.asList("poker", "holdem"));
        book4.setReleaseDate(LocalDate.now());
        book4.setEdition(1);
        book4.setSummary("This is a summary");
        book4.getAuthors().addAll(Arrays.asList(author1));
        book4.getCategories().add(category1);
        book4.setFormat(format);
        book4.setType(type);
        book4.setImages(new HashSet<>(Arrays.asList("card.jpg", "ace.jpg")));

        bookRepository.save(Arrays.asList(book1, book2, book3, book4));
    }
}