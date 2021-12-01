package com.advanced;

import java.util.ArrayList;

public class Stack<type> {
    private ArrayList<type> stack = new ArrayList<>();
    int head = -1;

    public void put(type object) {
        this.head++;
        this.stack.add(head, object);
    }

    public type pull() {
        type returnable = this.stack.get(head);
        this.stack.remove(head);
        this.head--;

        return returnable;
    }
}
