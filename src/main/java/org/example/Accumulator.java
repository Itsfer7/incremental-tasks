package main.java.org.example;

public class Accumulator {

    private int value;

    public synchronized void increment() {
        value = value + 1;
    }

    public int getValue() {
        return value;
    }
}