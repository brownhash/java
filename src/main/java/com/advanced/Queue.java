package com.advanced;

import java.util.ArrayList;

public class Queue<type> {
    private ArrayList<type> queue = new ArrayList<>();

    public void push(type object) {
        this.queue.add(object);
    }

    public type pull() {
        type returnable = this.queue.get(0);
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
