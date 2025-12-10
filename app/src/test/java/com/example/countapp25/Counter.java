package com.example.countapp25;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}