package com.example.model;

import com.example.annotation.JsonField;

public class Person {

    @JsonField(name = "name")
    private String name;

    @JsonField(name = "age")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}