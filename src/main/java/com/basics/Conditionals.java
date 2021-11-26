package com.basics;

public class Conditionals {
    void ifElse(int num) {
        if (num < 0) System.out.println("\t" + num + " is negative integer");
        else if (num == 0) System.out.println("\t" + num + " is zero");
        else System.out.println("\t" + num + " is positive integer");
    }

    void switchStatement(String name) {
        switch(name) {
            case "tom":
                System.out.println("\tTom made the call");
                break;
            case "jerry":
                System.out.println("\tJerry made the call");
                break;
            default:
                System.out.println("\tDefault call");
        }
    }
}
