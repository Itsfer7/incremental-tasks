package main.java.org.example;

public class IncrementThread extends Thread {

    private final Accumulator accumulator;

    public IncrementThread(Accumulator accumulator) {
        this.accumulator = accumulator;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            accumulator.increment();
            System.out.println(accumulator.getValue());
        }
    }
}