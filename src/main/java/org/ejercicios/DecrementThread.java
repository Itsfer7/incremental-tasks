package main.java.org.ejercicios;

public class DecrementThread implements Runnable {

    private final Accumulator accumulator;
    private final int waitTime;

    public DecrementThread(Accumulator accumulator, int waitTime) {
        this.accumulator = accumulator;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        while (accumulator.getValue() != 0) {
            accumulator.decrement();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}