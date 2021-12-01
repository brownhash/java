package com.advanced;

public class Advanced {
    public static void main(String[] args) {
        System.out.println("Java advanced!");

        // custom data types
        // 1. Stack
        // initiate a new instance of class Stack present in same package
        com.advanced.Stack stack = new com.advanced.Stack();
        System.out.println("\nStack -");
        System.out.println("\tstack head: " + stack.head);
        System.out.println("\tputting data...");
        stack.put("some data");
        System.out.println("\tstack head: " + stack.head);
        System.out.println("\tpulling data... value: " + stack.pull());
        System.out.println("\tstack head: " + stack.head);
    }
}
