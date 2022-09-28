package main.java.org.ejercicios;

public class Accumulator {

    private int value;

    public Accumulator(int value) {
        this.value = value;
    }

    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }
}