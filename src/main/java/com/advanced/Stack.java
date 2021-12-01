package com.advanced;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Object> stack = new ArrayList<>();
    int head = -1;

    public void put(Object object) {
        this.head++;
        this.stack.add(head, object);
    }

    public Object pull() {
        Object returnable = this.stack.get(head);
        this.stack.remove(head);
        this.head--;

        return returnable;
    }
}
