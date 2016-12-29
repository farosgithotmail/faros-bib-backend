package com.faros.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Data
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String userName;
    private String password;
    private String email;
    private boolean active;
    private String phoneNumber;
    private Set<Role> roles;
}
