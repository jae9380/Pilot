package com.step4.problem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java standard library class {@link java.util.ArrayList}를 참고하여 직접 구현
 *
 * Reference: {@code java.util.ArrayList}, JDK 17
*/
public class BiologicalSystem<G> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public BiologicalSystem() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        System.out.println("[BiologicalSystem] 생물정보 시스템이 생성되었습니다.");
    }

    public BiologicalSystem(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.size = 0;
    }

    public boolean add(G g) {
        ensureCapacity(size + 1);
        elementData[size++] = g;
        System.out.printf("[BiologicalSysTem] 새로운 생물이 등록되었습니다 : %s\n", ((BiologicalEntity<?>) g).getName());
        return true;
    }

    public void add(int index, G g) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = g;
        System.out.printf("[BiologicalSysTem] 새로운 생물이 등록되었습니다 : %s\n", ((BiologicalEntity<?>) g).getName());

        size++;
    }

    public void add(G... g) {
        for (G g1 : g) {
            add(g1);
        }
    }

//    delete()
    public G delete(int index) {
        rangeCheck(index);
        G oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    public boolean delete(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    if (o instanceof BiologicalEntity<?>) {
                        System.out.printf("[BiologicalSysTem] 해당 생물이 삭제되었습니다 : %s\n", ((BiologicalEntity<?>) o).getName());
                    }
                    return true;
                }
            }
        }
        return false;
    }

//    clear()
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
        System.out.println("[BiologicalSysTem] 생물 정보 리스트 전체 데이터를 삭제 했습니다.");
    }

//    show()
    public void show() {
        if (size == 0) {
            System.out.println("[BiologicalSysTem] 생물 정보 리스트가 비어 있습니다.");
        } else {
            System.out.printf("[BiologicalSysTem] 가장 최근에 추가된 생물 정보: %s\n", ((BiologicalEntity<?>)elementData[size - 1]).getName());
        }
    }

//    isEmpty()
    public boolean isEmpty() {
        System.out.printf("[BiologicalSysTem] %s\n", size == 0 ? "생물 정보 리스트가 비어 있습니다." : "생물 정보 리스트가 비어 있지 않습니다.");
        return size == 0;
    }

    public int size() {
        System.out.printf("[BiologicalSysTem] 생물 정보 리스트의 길이는 %d 입니다.\n", size);

        return size;
    }

//    ---- private Method ----
/*
    배열의 크기를 늘려야 하는 상황에서 기본적으로 1.5배로 늘리는 것이 우선 계산을 한다.
    만약, 1.5배에 만족을 하지 않는 경우에 추가적으로 더 늘려준다.
*/
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            int newCapacity = elementData.length + (elementData.length >> 1);
            if (newCapacity < minCapacity) newCapacity = minCapacity;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @SuppressWarnings("unchecked")
    private G elementData(int index) {
        return (G) elementData[index];
    }
}
