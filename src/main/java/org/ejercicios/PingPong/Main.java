package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);

        semaphore.acquire(1);

        int times = 10;

        Thread pingThread = new Thread(new PingThread(times, semaphore));
        Thread pongThread = new Thread(new PongThread(times, semaphore));

        pingThread.start();
        pongThread.start();
        semaphore.release();
    }
}