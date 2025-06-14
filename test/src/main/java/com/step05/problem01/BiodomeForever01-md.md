## CalssLoader - 리소스 파일 로딩    

```java
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream is = classLoader.getResourceAsStream("step05/problem01/" + fileName);
```

`ClassLoader`는 자바 클래스 및 리소스 파일을 **JVM**의 클래스 경로에서 로딩하는 역활을 수행한다.   
해당 코드에서 `getResourceAsStream()`을 호출하여 `InputStream`형태의 값을 변환한다.  

## InputStream - 바이트 기반 스트림

`InputStream`의 경우 데이터를 1byte 단위로 읽는 추상 클래스이다. 그리고 기본적으로 텍스트의 인코딩을 고려하지 않는다는 점이 존재한다.


```java
InputStream is = classLoader.getResourceAsStream("step05/problem01/" + fileName);
```

## InputStreamReader - 바이트 → 문자 변환
```java
reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
```
`InputStream` 에서 텍스트를 인코딩하지 않는다고 했다. 그렇기 때문에 한글을 읽을 경우 깨지는 문제가 발생된다.     

한글 깨지는 문제를 해결하기 위해서 `InputStreamReader`을 이용하여 바이트 스트림을 문자 스트림으로 변환을 해준다. 그리고 "UTF-8"을 추가하여 문자 인코딩 방식을 명시하여 문제를 해결


##  BufferedReader - 효율적인 문자 읽기
```java
reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
```
```java
String line;
while ((line = reader.readLine()) != null) {
    content.append(line).append("\n");
}
```
`BufferedReader`는 문자 스트림을 버퍼에 모아서 읽기 때문에 입출력 성능이 향상이 된다.   
또한 `readLine()`을 통하여 하나의 줄씩 텍스트 데이터를 읽을 수 있다.    

위 기능을 이용하여 한 줄씩 `StringBuilder`에 추가하려 전체 내용을 누적하여 데이터를 다룰 수 있다.

## try-with-resources + finally - 리소스 안전 관리

```java
try (InputStream is = getFileAsStream(fileName)) {
    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    ...
} catch (FileNotFoundException e) {
    System.out.println(e.getMessage());
} catch (IOException e) {
    System.out.println("리소스 파일을 읽는 중 오류 발생: " + fileName);
} finally {
    try {
        if (reader != null) reader.close();
    } catch (IOException e) {
        System.out.println("리소스 파일 닫는 중 오류 발생: " + fileName);
    }
}
```

`try-with-resources`를 사용하면 `InputStream은` 자동으로 `close()`가 된다.    
하지만 `BufferedReader는` `try()` 안에서 선언되지 않아 수동으로 `finally`에서 닫아야 함    
파일이나 네트워크와 같은 외부 자원은 반드시 닫아야 하며, 그렇지 않으면 리소스 누수가 발생합니다.