package com.faros.repositories;

import com.faros.domain.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface BookRepository extends MongoRepository<Book, ObjectId>{
}
