package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore pingSemaphore = new Semaphore(1);
        Semaphore pongSemaphore = new Semaphore(1);
        pongSemaphore.acquire(1);

        Thread pingThread = new Thread(new PingThread(10, pingSemaphore, pongSemaphore));
        Thread pongThread = new Thread(new PongThread(10, pongSemaphore, pingSemaphore));

        pingThread.start();
        pongThread.start();
    }
}