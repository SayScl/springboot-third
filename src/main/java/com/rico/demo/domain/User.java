package com.rico.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Rico on 2017/6/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
