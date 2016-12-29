package com.faros.repositories;

import com.faros.domain.BookFormat;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by juchtdi on 29/12/2016.
 */
public interface BookFormatRepository extends MongoRepository<BookFormat, ObjectId> {
}
