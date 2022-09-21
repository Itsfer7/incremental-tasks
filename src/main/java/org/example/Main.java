package main.java.org.example;

public class Main {
    public static void main(String[] args){

        Thread thread = new Thread(new IncrementThread(new Accumulator()));
        Thread thread2 = new Thread(new IncrementThread(new Accumulator()));

        thread.start();
        thread2.start();
    }
}