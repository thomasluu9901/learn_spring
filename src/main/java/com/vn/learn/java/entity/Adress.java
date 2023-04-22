package com.vn.learn.java.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author thomas_luu
 * @created 21/04/2023 - 3:34 PM
 * @project learn_spring
 */
@Entity(name = "adress")
@Getter
@Setter
@ToString
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
}
