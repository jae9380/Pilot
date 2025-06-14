package com.step04.problem05;

public class PlantHashMap<K, V> {
    private static final int SIZE = 16;
    private Entry<K, V>[] table;

    public PlantHashMap() {
        this.table = new Entry[SIZE];
        System.out.println("[PlantHashMap] 식물 관리 해시맵이 생성되었습니다.");
    }

    /**
     * 체이닝(chaining) 하지 않기 때문에 주어진 @index index에 값이 있으면 새로운 값으로 덮는다.
     */
    public void put(K k, V v){
        int index = getIndex(k);
        table[index] = new Entry<>(k, v);
        System.out.printf("[PlantHashMap] 식물 등록 - 이름: %s, 특징: %s (index: %d)\n", k, v, index);

    }

    public Entry<K, V> get(K k){
        int index = getIndex(k);
        Entry<K, V> answer = table[index];
        if (answer != null && answer.key.equals(k)) {
            System.out.printf("[PlantHashMap] 식물 조회 - 이름: %s, 특징: %s (index: %d)\n", k, answer.value, index);
        } else {
            System.out.printf("[PlantHashMap] 식물 조회 실패 - 이름: %s (index: %d)\n", k, index);
        }
        return answer;
    }

    public V remove(K k){
        int index = getIndex(k);
        Entry<K, V> entry = table[index];
        if (entry != null && entry.key.equals(k)) {
            System.out.printf("[PlantHashMap] 식물 삭제 - 이름: %s, 특징: %s (index: %d)\n", k, entry.value, index);
            table[index] = null;
            return entry.value;
        } else {
            System.out.printf("[PlantHashMap] 식물 삭제 실패 - 이름: %s (index: %d)\n", k, index);
            return null;
        }
    }

    public int getIndexAndDisplayInfo(K k) {
        int index = k.hashCode() < 0 ? -k.hashCode()  % SIZE : k.hashCode() % SIZE;
        System.out.printf("[PlantHashMap] \'%1$s\'의 인덱스 - %2$d \n", k, index);
        return index;
    }
    private int getIndex(K k){
//        hashCode()를 사용하여 K의 인덱스를 나머지 연산으로 인덱스 지정
        return k.hashCode() < 0 ? -k.hashCode()  % SIZE : k.hashCode() % SIZE;
    }

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
