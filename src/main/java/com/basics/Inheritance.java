package com.basics;

public class Inheritance extends AdvancedDataTypes {
    Inheritance() {
        System.out.println("\t" + super.getClass() + " inherited " + AdvancedDataTypes.class);
    }

    void properties() {
        System.out.println("\tInherited properties");
        System.out.println("\t\tStringVar: " + super.StringVar);
        System.out.println("\t\tArrayListVar: " + super.ArrayListVar);
        System.out.println("\t\tIntArray: " + super.IntArray);
        System.out.println("\t\tMapVar: " + super.MapVar);
    }
}
