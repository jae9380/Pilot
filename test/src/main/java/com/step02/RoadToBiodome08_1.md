# FIFO (First In First Out)

## Method

### 삽입
* add(type value);
    * 삽입 성공 시 true 반환 / 실패 시 `IllegalStateException` 반환
* offer(type value);
    * 삽입 성공 시 true 반환 / 실패 시 false 반환

### 삭제
* remove();
    * 큐의 첫 번째 요소를 제거하고 반환. 큐가 비어있으면 `NoSuchElementException` 발생
* remove(type value);
    * 해당 객체와 일치하는 요소 하나를 제거함. 제거 성공 시 true, 실패 시 false 반환
* poll();
    * 큐의 첫 번째 요소를 반환하고 제거함. 큐가 비어 있으면 `null` 반환

### 반환
* element();
    * 큐의 첫 번째 요소를 제거하지 않고 반환함. 큐가 비어있으면 `NoSuchElementException` 발생
* peek();
    * 큐의 첫 번째 요소를 제거하지 않고 반환함. 큐가 비어 있으면 `null` 반환

### 초기화
* clear();
    * 큐의 모든 데이터를 초기화 한다.

### 크기
* size();
    * 큐의 사이즈를 반환한다.

### 원소 찾기
* contains(type value);
    * 큐에 해당하는 데이터의 존재 여부를 반환한다.

### 공백 여부
* isEmpty(); 
    * 큐가 비어있는지 여부를 반환한다. 