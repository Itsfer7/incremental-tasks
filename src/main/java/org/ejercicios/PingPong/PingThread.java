package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class PingThread implements Runnable {

    private final int times;
    private final Semaphore pingSemaphore;
    private final Semaphore pongSemaphore;

    public PingThread(int times, Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.times = times;
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                pingSemaphore.acquire(1);
                System.out.println("Ping");
                pongSemaphore.release(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}