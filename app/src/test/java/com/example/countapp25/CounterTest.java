package com.example.countapp25;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CounterTest {

    @Test
    public void testInitialCount() {
        Counter counter = new Counter();
        assertEquals(0, counter.getCount());
    }

    @Test
    public void testIncrement() {
        Counter counter = new Counter();
        counter.increment();
        assertEquals(1, counter.getCount());
    }

    @Test
    public void testDecrement() {
        Counter counter = new Counter();
        counter.decrement();
        assertEquals(-1, counter.getCount());
    }

    @Test
    public void testReset() {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.reset();
        assertEquals(0, counter.getCount());
    }

    @Test
    public void testMultipleOperations() {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.decrement();
        assertEquals(1, counter.getCount());
    }
}