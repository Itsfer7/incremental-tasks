package main.java.org.ejercicios.PingPong;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);

        semaphore.acquire(1);

        int times = 10;

        Thread pingPongThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < times; i++) {
                        semaphore.acquire(1);
                        System.out.println("Ping");
                    }
                    semaphore.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread pongThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire(1);
                    for (int i = 0; i < times; i++) {
                        System.out.println("Pong");
                    }
                    semaphore.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //pingThread.start();
        pongThread.start();
        semaphore.release();
    }
}