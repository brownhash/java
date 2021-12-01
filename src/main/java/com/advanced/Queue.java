package com.advanced;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Object> queue = new ArrayList<>();

    public void push(Object object) {
        this.queue.add(object);
    }

    public Object pull() {
        Object returnable = this.queue.get(0);
        this.queue.remove(0);

        return returnable;
    }

    public boolean isEmpty() {
        return !(this.queue.size() > 0);
    }

    public int size() {
        return this.queue.size();
    }
}
