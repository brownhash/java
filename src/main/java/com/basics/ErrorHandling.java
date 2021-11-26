package com.basics;

public class ErrorHandling {
    void tryCatch() {
        com.basics.AdvancedDataTypes advancedDataTypes = new com.basics.AdvancedDataTypes();
        try {
            advancedDataTypes.IntArray[0] = 1;
            advancedDataTypes.IntArray[1] = 2;
            advancedDataTypes.IntArray[2] = 3; // will throw exception because the size of array is 2
        } catch (Exception e) {
            System.out.println("\tException caught! " + e.getClass());
        }
    }
}
