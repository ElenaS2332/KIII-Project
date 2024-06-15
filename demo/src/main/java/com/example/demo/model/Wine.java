package com.example.demo.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Wine {

    @Column(length = 1000)
    String name;

    @Column(length = 1000)
    String sort;
    int year;

    @Column(length = 1000)
    String producedInRegion;

    public Wine(String name, String sort, int year) {
        this.name = name;
        this.sort = sort;
        this.year = year;
        this.producedInRegion = producedInRegion;
    }
}
