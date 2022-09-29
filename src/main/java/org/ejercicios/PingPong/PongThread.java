package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class PongThread implements Runnable {

    private final int times;
    private final Semaphore pongSemaphore;
    private final Semaphore pingSemaphore;

    public PongThread(int times, Semaphore pongSemaphore, Semaphore pingSemaphore) {
        this.times = times;
        this.pongSemaphore = pongSemaphore;
        this.pingSemaphore = pingSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                pongSemaphore.acquire(1);
                System.out.println("PONGPONGPONG");
                pingSemaphore.release(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}