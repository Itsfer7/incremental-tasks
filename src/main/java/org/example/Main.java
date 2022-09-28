package main.java.org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Accumulator accumulator = new Accumulator(0);

        LinkedList<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new IncrementThread(100, accumulator));
            threads.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final value: " + accumulator.getValue());
    }
}