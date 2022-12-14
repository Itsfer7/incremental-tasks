package main.java.org.example;

public class IncrementThread implements Runnable {

    private final Accumulator accumulator;
    private final int times;

    public IncrementThread(int times ,Accumulator accumulator) {
        this.times = times;
        this.accumulator = accumulator;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < times; i++) {
            accumulator.increment();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}