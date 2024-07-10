package com.example.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table(name="foo")
public class Foo {
    public UUID id;
    public String name;

}

