package main.java.org.ejercicios.IncrementDecrement;

public class IncrementThread implements Runnable {

    private final Accumulator accumulator;
    private final int waitTime;

    public IncrementThread(Accumulator accumulator, int waitTime) {
        this.accumulator = accumulator;
        this.waitTime = waitTime;
    }

    @Override
    public synchronized void run() {
        while (accumulator.getValue() != 0) {
            accumulator.increment();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}