## getResourceAsStream()에서  getResourceAsStream()으로 바꾼 이유    

2번 문제의 경우 1번 문제에서 파일 이름 앞에 위치한 12자리 숫자들을 사용하여 yyyy-MM-dd HH:mm 형태로 포멧하여 출력하는 기능을 구현 해야 한다.    

그래서 입력값으로 받아오는 .txt 파일의 이름으로 검증하는 방법이 아닌, 입력값을 기준으로 찾은 데이터의 이름을 기준으로 검증하기 위해서 변경했다.    

```java
// 문제 1번 부분 코드
InputStream is = classLoader.getResourceAsStream("step05/problem01/" + fileName);

// 문제 2번 부분 코드
String resourcePath = "step05/problem02/" + fileName;
URL resourceUrl = classLoader.getResourceAsStream(resourcePath);
// ...
File file = new File(resourceUrl.toURI());
```

> 두 메서드는 어떤 기능을 어떤 목적으로 사용하는 것일까?     

일단 두 메서드는 파일을 접근하기 위해서 사용을 한다는 공통점이 있다. 

두 메서드의 구현부를 확인을 하자.
```java
    public InputStream getResourceAsStream(String name) {
    Objects.requireNonNull(name);
    URL url = getResource(name);
    try {
        return url != null ? url.openStream() : null;
    } catch (IOException e) {
        return null;
    }
}


    public URL getResource(String name) {
        Objects.requireNonNull(name);
        URL url;
        if (parent != null) {
            url = parent.getResource(name);
        } else {
            url = BootLoader.findResource(name);
        }
        if (url == null) {
            url = findResource(name);
        }
        return url;
    }
```

먼저 `getResource()`의 경우를 보면 일단 리턴 타입으로 `URL`을 반환하고 있는 것을 확인할 수 있다.        

실행 블럭 내부를 보면 부모 클래스 로더에게 먼저 해당 리소스가 있는지 확인을 하고, 만약 부모 객체에서 찾지 못하면 자신이 직접 찾게 된다. 이를 통해서 얻은 URL 정보를 반환을 한다.    
(ClassLoader가 상위 로더에게 위임 하는 이유는 **Parent Delegation Model** 때문이다.)

이렇게 입력값과 동일한 파일의 위치를 찾았으면 `File` 객체로 만들어서 접근을 하게 된다.

다음으로 `getResourceAsStream()`의 경우를 보면 내부적으로 `getResource()`메서드를 호출하여 위치 정보를 얻은 다음에 `.openStream()`을 호출하여 `InputStream`형태로 반환한다.

### 그러면 두 방법으로 얻은 파일은 어떻게 사용이 되는 것인가?    
`getResourceAsStream()`방법은 해당 파일의 내부 데이터를 바이너리 데이터 스트림으로 읽고 있다. 그렇기 때문에 파일의 내부 데이터에만 접근이 가능하다는 것이다.    

하지만 `getResource()`의 경우 `File`객체로 만들어서 사용하고 있다. 이를 통해서 파일의 속성이나 파일의 경로 등 전체적인 정보를 얻어 사용할 수 있는 형태가 되어 
`getResourceAsStream()`의 경우와 다르게 내부 데이터 뿐 아니라 전반적인 데이터에 대한 접근이 가능하게 만들어 주는 차이점이 존재한다.

---

## Exception 구현부에 serialVersionUID 상수는 무엇을 하는 거지?    

해당 상수는 직렬화(Serialization)와 역직렬화(Deserialization) 과정에서 클래스의 버전이 동일여부를 식별하기 위해 사용이 된다.   

만약 해당 상수의 값이 다르게 된다면 `InvalidClassException` 예외가 발생하게 되어 버전이 다른 클래스를 역직렬화를 할 수 없게 막게 된다.    

문제에서 예외를 직접 만들어서 사용을 하라고 정의되어 있다. 그래서 예외 클래스를 만들고 선언부에 `Exception`을 상속 받아서 구현을 했다. 그리고 `Exception`는 `Serializable`을 구현하고 있다.        
```java
public class Exception extends Throwable implements Serializable
```

그렇기 떄문에 직접 작성하는 예외 클래스에서 상수를 직접 선언을 했다.

```java
private static final long serialVersionUID = 1L;
```
    
> 만약에 직접 상수를 선언하지 않을 경우 어떻게 될까?   

다행이도 해당 상수를 선언하지 않게 된다면 자바에서 자동으로 해당 상수를 선언해준다. 하지만 클래스의 구조에 따라 변경된다. 그렇기 때문에 클래스 구조가 
변경이 되면서 상수 또한 바뀌게 된다면 버전이 달라졌다고 판단하는 경우가 발생할 수 있다.     

이러한 문제를 해결하기 위해서 직접 상수를 선언하는 방법이 안전하다.    


> 클래스의 구조가 변경되면 상수의 값 또한 변경이 된다고 했는데, 우리가 작성하는 일반적인 자바 파일에도 해당 상수를 선언 해야하나?    

우리가 일반적으로 작성하는 자바 파일에서 사용할 필요는 없다. 다만, `Serializable` 인터페이스를 구현하는 경우에는 상수를 선언하는 것이 좋다.    

정리 하자면 `Serializable`을 구현하지 않는 일반적인 클래스, 직렬화를 사용하지 않는 클래스의 경우에는 선언할 필요가 없다.   





