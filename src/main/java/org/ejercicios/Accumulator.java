package main.java.org.ejercicios;

public class Accumulator {

    private int value;

    public Accumulator(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }
}