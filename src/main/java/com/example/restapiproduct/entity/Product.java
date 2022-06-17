package com.example.restapiproduct.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Buider
public class Product {
    private int id;
    private String name;
    private String slug;
    private String thumbnail;
    private String description;
    private int status;
}
