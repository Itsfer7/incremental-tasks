package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire(1);

        Thread pingThread = new Thread(new PingThread(10, semaphore));
        Thread pongThread = new Thread(new PongThread(10, semaphore));

        pingThread.start();
        pongThread.start();
        semaphore.release();
    }
}