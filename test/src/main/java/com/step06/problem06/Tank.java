package com.step06.problem06;

public class Tank implements Runnable{
    private final long number;
    private final Object lock;
    private final Object nextLock;
    private int waterAmount;

    public Tank(long number, Object lock, Object nextLock) {
        this.number = number;
        this.lock = lock;
        this.nextLock = nextLock;
        this.waterAmount = 0;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                // 첫번째 탱크는 바로 실행, 나머지는 대기
                lock.wait();
            }

            while (waterAmount < 100) {
                Thread.sleep(1000); // 1초 대기
                waterAmount += 10;
                System.out.printf("물 저장소 %d: %d리터%n", number, waterAmount);
            }

            synchronized (nextLock) {
                nextLock.notify(); // 다음 저장소 깨우기
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
