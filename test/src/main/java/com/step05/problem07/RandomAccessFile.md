# **RandomAccessFile**

자바에서 파일을 읽거나 쓰는 동작을 할 때 기본적으로 `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`, `FileInputStream`, `FileOutputStream`을 사용하게 된다. 하지만, 이들은 대부분 **순차적으로 파일을 처리**하게 되며, **특정 위치의 데이터를 직접 수정하거나 읽기에는 제약**이 있다.

```java
public class FileWriteExample {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write("Hello, Java File IO!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class FileReadExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

이렇게 자주 사용되는 입/출력 클래스들의 방법은 모두 파일을 읽고 쓰는 작업에 있어 각각의 객체를 사용 해야 한다는 점과 **연속적인 순차 처리**를 하게 된다는 점이 존재한다.

## RandomAccessFile

`java.io` 패키지에 포함되어 있는 `RandomAccessFile`클래스는 앞에서 확인한 클래스와 달리 **읽기와 쓰기** 동작을 한 번에 수행할 수 있으며, **특정 위치에 있는 데이터에 대한 접근이 가능**하다는 특징이 있다.

### 객체 생성

```java
RandomAccessFile raf = new RandomAccessFile(파일 패스, 모드);
RandomAccessFile raf = new RandomAccessFile(파일, 모드);
```

`RandomAccessFile`에서 지원하는 생성자는 기본적으로 두 가지 인자를 받아서 생성된다.     
가장 먼저 **파일 경로 or 파일**에 대한 값과 어떤 방법으로 사용할 것인지에 대한 **모드**를 받아서 생성된다.

* 모드의 종류와 기능
  | **모드**  | **설명**                      | **파일 존재 시**          | **파일 미존재 시**             |
  |:-------:|:---------------------------:|:--------------------:|:------------------------:|
  | **r**   | 읽기 전용 (Read-only)           | 파일 내용을 읽을 수 있음       | FileNotFoundException 발생 |
  | **rw**  | 읽기 + 쓰기 (Read/Write)        | 기존 내용을 읽고 수정 가능      | 새로 생성                    |
  | **rws** | "rw" + 데이터와 메타데이터 즉시 디스크 반영 | 데이터 + 메타데이터 동기화      | 새로 생성                    |
  | **rwd** | "rw" + 데이터만 즉시 디스크 반영       | 데이터만 동기화, 메타데이터는 나중에 | 새로 생성                    |

> 만약 읽기 전용 모드에서 쓰기 동작을 할 경우 **IOException** 예외가 발생된다.

### 다른 입출력 클래스와 RandomAccessFile의 차이점

앞에서 다른 입출력 클래스에 대해서 너무 간략하게 이야기를 했다고 생각되어 다시 짚고 넘어가겠다.

각 방법에 대한 차이점을 목적을 기준으로 어떤 차이점을 갖고 있는지 확인을 하자.

* **데이터 접근**
  `RandomAccessFile`의 경우**파일 내 특정 위치 임의 접근(Random Access)**할 수 있도록 포인터를 제공하기 때문에 원하는 위치로 이동하여 데이터를 읽거나 쓸 수 있다.

  반면, 다른 방법들은 일반적인 스트림 기반 클래스로 **순차적인 접근(sequential access)**만을 지원하게 된다. 그렇기 때문에 특정 위치의 데이터를 읽거 쓰기 위해서는 앞에 있는 모든 데이터를 거쳐야 한다.

* **읽기/쓰기**
  `RandomAccessFile`의 `rw` 모드 경우 **하나의 객체로 읽기와 쓰기 작업을 모두 수행할 수 있다**.

  하지만 다른 클래스들인 일반적으로 읽기 전용이나 쓰기 전용으로 구분되어 있어 각 동작에 맞는 객체를 생성하여 객체의 단일 목적 행동을 해야 한다.

* 파일 수정
  일반적인 입/출력 클래드에서는 파일의 중간 내용을 수정하는 기능이 없다. 그렇기 때문에 보통 전체 파일의 내용을 메모리에 읽은 후 변경한 데이터를 **새 파일에 다시 기록**하는 방식으로 간접적으로 수정하게 된다.

  반면에  `RandomAccessFile` 의 경우에는 **파일 내 특정 위치를 찾아가 그 자리에서 직접 데이터를 덮어쓰는 방식**으로 수정이 가능하며, 보다 효율적인 수정 작업이 가능하다.

### 사용 예제 코드
```java
import java.io.RandomAccessFile;
import java.io.IOException;

public class RAFExample {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("data.txt", "rw")) {
            raf.writeUTF("Hello");
            raf.writeInt(123);
            
            raf.seek(0); // 포인터를 처음으로 이동
            String msg = raf.readUTF();
            int number = raf.readInt();

            System.out.println("읽은 메시지: " + msg);
            System.out.println("읽은 숫자: " + number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

```java
raf.seek(raf.length() / 2); // 중간 위치로 이동
raf.writeUTF("중간 삽입");
```

### 정의되어 있는 메서드와 기능

| **메서드** | **설명** |
|:-:|:-:|
| read(), readInt(), readUTF() | 다양한 방식으로 파일 읽기 |
| write(), writeInt(), writeUTF() | 다양한 방식으로 파일 쓰기 |
| seek(long pos) | 파일 포인터를 지정한 위치로 이동 |
| getFilePointer() | 현재 파일 포인터 위치 반환 |
| length() | 파일의 전체 길이 반환 |
| setLength(long newLength) | 파일 크기 조절 (잘라내거나 확장) |

### 사용시 주의 점

`RandomAccessFile`을 사용할 때 **쓰레드는 불안정한 상태**가 된다. 그렇기 때문에 **멀티 쓰레드 환경에스는 적절한 동기화 작업**이 필요하게 된다.

또한, 파일 크기 조작에 있어 주의를 해야한다. `seek()`메서드의 경우 파일의 끝보다 큰 위치로 이동할 수 있으나, 중간의 공백으로 채워지지 않기 때문에 포인터 조작에 있어서 주의를 해야 한다.    
