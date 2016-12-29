package com.faros.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Data
@Document(collection = "bookTypes")
public class BookType {
    @Id
    private ObjectId id;
    private String name;
}
