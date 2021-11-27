package com.basics;

// this class
public class Polymorphism {
    public String name = "";

    Polymorphism(String name) {
        this.name = name;
    }

    Polymorphism(String name, int count) {
        for (int i = 0; i < count; i++) {
            this.name += name + ",";
        }
    }
}
