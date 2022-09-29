package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class PongThread implements Runnable {

    private final int times;
    private final Semaphore semaphore;

    public PongThread(int times, Semaphore semaphore) {
        this.times = times;
        this.semaphore = semaphore;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < times; i++) {
            try {
                semaphore.acquire(1);
                System.out.println("Pong");
                semaphore.release(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}