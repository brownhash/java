package com.basics;

public class Loops {
    void forLoop(int counter) {
        System.out.printf("\tFor loop - ");
        for(int i = 0; i < counter; i ++) {
            System.out.printf("%d,", i);
        }
        System.out.println();
    }

    void whileLoop(int counter) {
        System.out.printf("\tWhile loop - ");
        int i = 0;
        while(i < counter) {
            System.out.printf("%d,", i);
            i++;
        }
        System.out.println();
    }

    void doWhileLoop(int counter) {
        System.out.printf("\tDoWhile loop - ");
        int i = 0;
        do {
            System.out.printf("%d,", i);
            i++;
        }while (i < counter);
        System.out.println();
    }

    void forEachLoop(int[] range) {
        System.out.printf("\tForEach loop - ");
        for (int num: range) {
            System.out.printf("%d,", num);
        }
        System.out.println();
    }
}
