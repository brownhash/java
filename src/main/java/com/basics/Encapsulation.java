package com.basics;

public class Encapsulation {
    // not accessible outside
    private String name;

    // allows only write
    void setName(String name) {
        this.name = name;
    }

    // allows only read
    String getName() {
        return this.name;
    }
}
