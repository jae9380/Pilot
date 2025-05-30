package com.step4.problem07;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class PlantPriorityQueue {
    private LinkedList<Plant> list;

    public PlantPriorityQueue() {
        this.list = new LinkedList<>();
    }

    /**
     *     public E peek() {
     *         return (E) queue[0];
     *     }
     * @param plant
     */

    public void add(Plant plant) {
        if (plant == null) throw new NullPointerException();
        offer(plant);
    }

    /**
     *      * Inserts the specified element into this priority queue.
     *      *
     *      * @return {@code true} (as specified by {@link Queue#offer})
     *      * @throws ClassCastException if the specified element cannot be
     *      *         compared with elements currently in this priority queue
     *      *         according to the priority queue's ordering
     *      * @throws NullPointerException if the specified element is null
     *
     *      public boolean offer(E e) {
     *          if (e == null) throw new NullPointerException();
     *          modCount++;
     *          int i = size;
     *          if (i >= queue.length) grow(i + 1);
     *          siftUp(i, e);
     *          size = i + 1;
     *          return true;
     *      }
     */
    public boolean offer(Plant plant) {
        if (plant == null) throw new NullPointerException();
        boolean added = list.add(plant);
        if (added) sort();
        return added;
    }

    /**
     *     public E poll() {
     *         final Object[] es;
     *         final E result;
     *
     *         if ((result = (E) ((es = queue)[0])) != null) {
     *             modCount++;
     *             final int n;
     *             final E x = (E) es[(n = --size)];
     *             es[n] = null;
     *             if (n > 0) {
     *                 final Comparator<? super E> cmp;
     *                 if ((cmp = comparator) == null)
     *                     siftDownComparable(0, x, es, n);
     *                 else
     *                     siftDownUsingComparator(0, x, es, n, cmp);
     *             }
     *         }
     *         return result;
     *     }
     *
     */
    public Plant poll() {
        if (list.isEmpty()) return null;
        Plant polled = list.removeFirst();
        return polled;
    }

    /**
     *     public E peek() {
     *         return (E) queue[0];
     *     }
     */
    public Plant peek() {
        if (list.isEmpty()) return null;
        return list.getFirst();
    }

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * <p>This implementation returns the result of {@code poll}
     * unless the queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty

     *  public E remove() {
     *      E x = poll();
     *      if (x != null) return x;
     *      else throw new NoSuchElementException();
     *  }
     */
    public boolean remove(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void sort() {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Plant temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("관리 중인 식물이 없습니다.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Plant plant = list.get(i);
            System.out.printf("이름 : %1$s \t필요한 양 : %2$dL \t공급 주기 : %3$d시간 \t마지막 공급 일자 : %4$s\n",
                    plant.getName(), plant.getWaterAmount(), plant.getWaterCycleHours(), plant.getLastWateredToString());
        }
    }
}
