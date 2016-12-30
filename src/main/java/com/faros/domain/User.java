package com.faros.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private String email;
    private boolean active;
    private String phoneNumber;
    @OneToMany
    private Set<Role> roles;

    public User(){

    }
}
