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

        // 2. Queue
        // initiate a new instance of class Stack present in same package
        com.advanced.Queue queue = new com.advanced.Queue();
        System.out.println("\nQueue -");
        System.out.println("\tIs queue empty? " + queue.isEmpty());
        System.out.println("\tqueue size: " + queue.size());
        System.out.println("\tputting data...");
        queue.push("some data");
        System.out.println("\tIs queue empty? " + queue.isEmpty());
        System.out.println("\tqueue size: " + queue.size());
        System.out.println("\tpulling data... value: " + queue.pull());
        System.out.println("\tIs queue empty? " + queue.isEmpty());
        System.out.println("\tqueue size: " + queue.size());
    }
}
