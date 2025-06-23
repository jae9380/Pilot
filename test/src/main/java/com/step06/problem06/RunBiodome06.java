package com.step06.problem06;

public class RunBiodome06 {
    public static void main(String[] args) throws InterruptedException {
        Object[] locks = new Object[6];
        for (int i = 0; i < 6; i++) {
            locks[i] = new Object();
        }

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Tank tank = new Tank(i + 1, locks[i], locks[i + 1]);
            threads[i] = new Thread(tank);
            threads[i].start();
        }

        synchronized (locks[0]) {
            locks[0].notify();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n물 채우기가 완료되었습니다.");
    }
}
