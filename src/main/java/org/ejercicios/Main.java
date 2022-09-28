package main.java.org.ejercicios;

public class Main {
    public static void main(String[] args){

        Accumulator accumulator = new Accumulator(100);

        Thread incrementThread = new Thread(new IncrementThread(accumulator, 20));
        Thread decrementThread = new Thread(new DecrementThread(accumulator, 10));

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final value: " + accumulator.getValue());
    }
}