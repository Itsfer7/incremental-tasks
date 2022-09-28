package main.java.org.ejercicios.IncrementDecrement;

public class Accumulator {

    private int value;

    public Accumulator(int value) {
        this.value = value;
    }

    public void increment() {
        synchronized (this) {
            value++;
        }
    }

    public void decrement() {
        synchronized (this) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }
}