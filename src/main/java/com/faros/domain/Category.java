package com.faros.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by juchtdi on 29/12/2016.
 */
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Category(){

    }
}
