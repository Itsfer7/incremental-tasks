package main.java.org.ejercicios.PingPong;

public class PingThread implements Runnable {

    private final int times;

    public PingThread(int times) {
        this.times = times;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("Ping");
        }
    }
}