package com.step02;


import java.util.Arrays;

public class RoadToBiodome08 {
    static Integer[] customQueue = new Integer[10];
    static int front = 0, rear = 0, size = 0;
    public static void main(String[] args) {

        for (String arg : args) {
            enqueue(Integer.parseInt(arg));
        }

        while (!isEmpty()) {
            System.out.printf("자원 %d을 제공했습니다. \n",dequeue());
        }
        System.out.printf("모든 요청이 처리되었습니다.");

    }

    static boolean enqueue(Integer value) { // .offer(type value);
        if (rear < 0 || rear > 99){
            return false;
        }

//      기본 크기 10, 동적으로 크기를 10씩 늘려감
        if ((rear+1) % 10 == 0) {
            customQueue = Arrays.copyOf(customQueue, customQueue.length + 10);
            System.out.printf("Queue의 크기가 %d으로 늘어났습니다.\n", customQueue.length);
        }
        customQueue[rear++] = value;
        size++;
        return true;
    }
    static Object dequeue() { // .poll();
        if (isEmpty()) return null;
        Object data = customQueue[front];
        front = (front + 1) % 100;
        size--;
        return data;
    }

    static Object peek() {
        if (isEmpty()) return null;
        Object data = customQueue[front];
        return data;
    }
    static boolean isEmpty() {
        return size == 0 ? true : false;
    }
}
