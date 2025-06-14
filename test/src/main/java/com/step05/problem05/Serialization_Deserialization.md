# JAVA 직렬화 / 역직렬화

## 🤔 직렬화, 역직렬화 그게 무엇일까?
다양한 프로그래밍 언어 중에서 Java는 객체 지향 언어이다. 모든 데이터와 기능을 객체 단위로 표현하여 사용하는 것을 쉽게 확인할 수 있다.       
하지만 문제는 JVM 내에서만 의마를 가지며, JVM 외부의 시스템(예를 들어 파일, 네트워크 등)에서는 자바 객체 를 직접 이해하거나 저장할 수 없다는 것이다.     
그렇기 떄문에 객체의 상태를 JVM외부로 전달하거나 저장하기 위해서 직렬화(Serialization)와 역직렬화(Deserialization) 라는 기술이 필요하게 된다.

![](https://i.postimg.cc/SN5zpX4Y/Serialization.jpg)

간단하게 각 개념은 어떻게 사용될까?
* **직렬화(Serialization)**: 자바 객체를 **바이트 스트림**으로 변환하여 파일, 네트워크, 데이터베이스 등 외부 매체에 저장하거나 전송할 수 있도록 한다.
* **역직렬화(Deserialization)**: 바이트 스트림으로부터 객체를 **복원**하여 다시 자바 객체로 사용할 수 있게 한다.

이러한 동작 개념을 바탕으로 이러한 상황에서 사용될 수 있다.
* 객체를 파일로 저장 및 재사용
* 객체를 네트워크를 통하여 다른 시스템으로 전송
* 객체를 세션 등에 저장 또는 Redis와 같은 캐시 서버에 저장

## Serializable Interface
우선 직렬화와 역직렬화에 대하여 자세히 알아보기 전에 `Serializable`인터페이스에 대해서 알아야 한다.

```java
public interface Serializable {
}
```

일단 해당 코드가 `Serializable` 구현 코드이다.  다른 인터페이스와 달리 내부에 아무런 코드가 정의되어 있지 않는 구조를 하고 있다.

그렇다 해당 인터페이스는 **마커 인터페이스**이다. 왜 마커 인터페이스로 구현이 되었나면, JVM이나 ObjectOutputStream 등에서 **해당 객체는 직렬화를 해도 안전하다**라는 점을 구분하여 실행하도록 제어 하기 위해서 사용되었다.

이를 통해서 메서드 없이 타입 체크 (instanceof)를 사용하여 **직렬화 가능 여부**를 판단할 수 있도록 했다.

> **ObjectOutputStream.writeObject(Object obj)**  메서드 내부에서는 아래와 같이 객체가 Serializable 인터페이스를 구현했는지를 검사하며, 이를 통해 **직렬화 가능 여부를 판단**합니다. 만약 구현되어 있지 않다면 NotSerializableException 예외가 발생하게 됩니다.
> ```java
> if (!(obj instanceof Serializable)) {
> 	throw new NotSerializableException(obj.getClass().getName());
> }   	
> ```

객체를 직렬화를 하는 과정에서 `ObjectOutputStream`에서 내부적으로 `Serializable`을 `implements`하고 있는지를 검사 하고 있기 때문에 해당 객체에서 `Serializable`을 구현 해줘야만 한다.

## 🔎 직렬화와 역직렬화
서론 부분에서 언제 어떻게 사용이 되는 기술인지를 알아보았다. 그럼 이제 자바에서 어떻게 사용해야 하는지 알아보자.

### 직렬화, Serialization

직렬화란 자바 객체의 Status를 바이너리 코드로 변환하고 저장과 전달을 하는 과정이다. 이를 통하여 데이터를 저장하거나, JVM 범위 외부에 있는 시스템으로 데이터를 전달하여 해당 데이터를 갖고 동작할 수 있도록 한다.

#### 주요 목적
직렬화의 주된 목적이라고 하면 데이터를 지속성 저장 및 전달이 주 목적이다.     
저장되는 데이터는 보통 객체의 정보, 객체의 구조, 클래스의 정보가 바이트 코드로 구성이 된다.

```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
oos.writeObject(myObject);
oos.close();
```

`ObjectOutputStream`을 생성할 때 `FileOutputStream("data.ser")`객체를 생성한다. 이는 “data.ser” 파일을 생성하거 열어 바이트 단위 데이터를 조작할 수 있도록 **파일 출력 스트림**을 생성한다.   
해당 스트림은 직렬화된 객체 데이터를 저장할 대상이 된다.

`ObjectOutputStream(OutputStream out)` 부분 에서는 앞에서 생성된 `FileOutputStream`을 감싸면서 객체 데이터를 **직렬화 가능한 포멧으로 변환**하여 스트림에 사용할 수 있는 기능을 제공하게 된다.

이렇게 생성된 `ObjectOutputStream`은 `writeObject`으로 데이터를 바이트로 변환하여 작성하고 `close`메서드로 닫게 되는 것이다.

### 역직렬화, Deserialization

역직렬화는 직렬화 동작 반대로 바이트 스트림에서 객체로 다시 복원하는 과정이다.

#### 주요 목적
저장되어 있거나 전송받은 정보를 다시 객체로 다시 사용하는 것이 주 목적이다.

```java
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
MyClass myObject = (MyClass) ois.readObject();
ois.close();
```

“data.ser” 파일은 렬화된 객체 정보다 담겨있는 소스이기 때문에 **바이트 입력 스트림**으로 열어준다.  그리고
`ObjectInputStream` 객체로 `FileInputStream`을 감써면서 **바이트 데이터를 객체 형태로 복원(역직렬화)**할 수 있도록 준비를 하게된다. _(여기서 내부적으로 스트림 해더를 읽고 직렬화 포멧을 검증하게 된다.)_    
그리고 다음으로 `readObject`메서드를 사용하여 해당 객체를 만들고 `close`를 사용하여 닫게 된다.

---

## 직렬화의 문제점
예를 들어서 아래의 객체를 직렬화를 한다고 가정을 하자
```java
public sample implements Serializable {
	String name;
	int value;
	MiniSample minisample;
}
```

### 참조 타입 필드의 직렬화 문제
객체 필드 중 참조 타입이 있을 때, `NotSerializableException` 예외가 발생할 수 있다. 해당 예외는 참조 타입의 필드가 `Serializable`을 구현하고 있지 않아서 발생한다.

위 예제 코드에서 참조 타입의 필드는 총 2가지이다. 하나는 `name`이라는 필드, 나머지 하나는 `minisample`이라는 필드이다.
참조 타입인`String`타입의 경우 내부적으로 정의가 되어 있어 문제는 없지만, `MiniSample`의 경우 내부적으로 `Serializable`을 구현해야 예외가 발생하지 않는다.

`MiniSample`의 경우 참조 필드가 깊게 중첩된 구조를 갖는다면, 직렬화 시 하위 모든 객체가 함께 직렬화되어 불필하게 높은 코스트를 발생시킬 수 있는 문제가 발생 된다.

### 상속 구조에서의 문제점
만약 위 예제 코드에서 상속 구조를 갖는다고 가정을 하자.

상위 클래스가 `Serializable`을 구현하지 않고, 하위 클래스에서 `Serializable`을 구현하여 하위 객체를 직렬화를 한다고 했을 때, 상위 클래스의 필드 정보는 포함되지 않고  직렬화가 된다. 그리고 반대로 역직렬화를 했을 때는 상위 객체에 대한 정보 없이 초기화 된다.

그렇기 때문에 상위 객체에 상태 정보가 있으면, 하위 객체를 직렬화를 해도 아무런 상태 정보없는 객체를 직렬화 하게 되는 것이다.

그렇기 때문에 하위 객체를 직렬화할 때 상위 객체에 대한 정보도 담고 싶으면 상위 객체도 `Serializable`을 구현 해줘야 한다.

### 과도한 직렬화

객체 내부에 많은 필드를 포함하거나, 깊은 참조 관계를 갖는 필드를 갖고 있을 경우의 객체를 직렬화 하게 된다면 데이터의 크기는 과대해지고 복잡성이 증가하게 되는 문제가 발생한다.



## 문제 해결 방법

### 참조 타입의 필드를 갖는 객체 직렬화
기본적인 해결 방법은 참조 타입 필드를 `Serializable`을 구현하는 것이다. (`String`의 경우는 내부적으로 구현)
직접 정의한 필드 객체가 있다면, 해당 클래스에도 `Serializable`을 구현 해줘야 한다. 하지만 불가능한 경우 직접 직렬화 / 역직렬화 정의를 한다면 해결 가능하다

### 직렬화 / 역직렬화 직접 정의
객체 내부에서 기본 직렬화 방식을 사용하지 않고, 직접적으로 로직을 정의할 수 있다.

해당 방법을 통하여 민감한 정보를 암호와 하거나, 특정 필드를 생략, 데이터 뱐환 등의 다양한 작업을 통해서 문제를 해결할 수 있다는 것이 장점이다.
```java
private void writeObject(ObjectOutputStream out) throws IOException {
    // 커스텀 직렬화 코드 작성
    out.defaultWriteObject();  // 기본 직렬화
    // 추가 처리 가능
}

private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    // 커스텀 역직렬화 코드 작성
    in.defaultReadObject();  // 기본 역직렬화
    // 추가 처리 가능
}
```

### 특정 필드 제외
객체를 직렬화할 때 꼭 모든 필드를 직렬화 해야 하는것은 아니다. 만약 직렬화에 필요없는 필드가 있을 경우 이를
`transient`을 선언하여 직렬화에서 제외 시키면 된다.
```java
transient MiniSample minisample;
```

해당 키워드를 통하여 `MiniSample`의 경우 직렬화에서 무시되며, 역직렬화 후에는 기본값을 갖게 된다.   

