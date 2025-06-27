# ServerSocket을 사용하여 통신하기

자바는 **TCP/IP** 네트워크 프로토콜을 기반으로 외부와의 통신을 하게된다.
**클라이언 - 서버** 구조로 클라이언트가 요청을 보내면 서버는 이에 대한 응답을 하게 된다. 그리고 서브는 항상 **특정 IP주소**와 **포트 번호**에서 연결 요청을 대기한다.

```
클라이언트   <------>   서버
   |                  |
[소켓(Socket)]     [서버소켓(ServerSocket)]
```

위 흐름과 같이 통신을 한다.
* 클라이언트가 서버의 IP와 프로토콜로 TCP 연결을 요청한다.
* 서버가 연결을 수락한다.
* 양쪽 모두 **Socket** 객체를 사용하여 데이터 송수신을 한다.

## 통신에 사용되는 클래

| **클래스** | **설명** |
|:-:|:-:|
| ServerSocket | 서버 측에서 포트를 열고 연결을 기다리는 클래스 |
| Socket | 클라이언트-서버 간 연결 후, 데이터 송수신 담당 |
| InputStream / OutputStream | 데이터를 바이트 단위로 읽고 씀 |
| BufferedReader / PrintWriter | 문자 기반 고수준 입출력 스트림 |


## ServerSocket 역활 및 원리

### 기본 생성
```java
ServerSocket serverSocket = new ServerSocket(8080);
```

자바 어플리케이션은 **ServerSocket** 객체를 생성하면서 포트 번호를 지정한다. 위 코드로 OS는 포트로 바인딩을 하여 **해당 포트에 대한 수신을 대기(Listen) 상태로 만드는 소켓 리소스를 할당**한다.
이때 포트는 **TCP 프로토콜**로 열리게 된다. (**ServerSocket**은 TCP용이다.)

**ServerSocket**은 지정된 포트에서 클라이언트의 연결 요청을 **수신 대기** 상태로 유지하고 있다가, `accept()`메서드를 통하여 클라이언트가 접속하면 TCP 연결을 수립하고, 해당 연결에 대한 Socket 객체를 반환하여 **양방향 통신이 가능하게 한다**.

### 연결 수락
```java
Socket socket = serverSocket.accept();
```

**ServerSocket**의 `accept()`메서드를 통하여 클라이언트 연결 요청이 오기 전까지 대기를 하게 된다.
다시 말해 클라이언트가 연결 요청을 할 때까지 **무한 대기(Blocking)**을 한다.

이렇게 대기를 하다가 클라이언트의 연결 요청이 들어온다면, 운영체제는 **TCP 3-way handshake**를 통하여 연결을 수립하게 된다.  연결이 성공적으로 수립이 된다면, `accept()`는 해당 연결을 다루는 **새로운 Socket객체를 반환**한다.

이 **Socket**객체를 통하여 클라이언트와 **양방향 스트림 기반 통신(InputStream/OutputStream)**이 가능해 지는 것이다.

### 클라이언트로 부터 데이터 받기

연결이 수립된 통신은 **Socket**이라는 객체를 통하여 **양방향 스트림 기반의 통신**이 가능해진다고 했다. 그렇기 때문에 해당 **Socket**객체 내부 메서드를 사용하여 **입력 스트립(InputStream)**을 받아서 **BufferedReader / InputStreamReader**를 사용하여 **문자 단위**로 처리한다.

```java
InputStream input = socket.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(input));
String line = reader.readLine(); // 클라이언트 요청 라인
```

### 클라이언트로 부터 데이터 보내기

또한 반대로 **출력 스트림(OutputStream)**을 얻어 **PrintWriter**로 감싸면 문자열 데이터를 편리하게 서버에서 클라이언트에게 데이터를 보낼 수 있다.

```java
OutputStream output = socket.getOutputStream();
PrintWriter writer = new PrintWriter(output, true);
writer.println("Hello from server!");
```

## 전체적인 흐름

```
[클라이언트 브라우저]
   |
   | 1. TCP 연결 요청 (IP + Port)
   ↓
[서버: ServerSocket(port)]  ← accept()
   ↓
[Socket] ← 연결됨
   ↓
InputStream / OutputStream 으로 데이터 송수신
```


## 예제 코드

```java
public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 실행 중... 포트 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = in.readLine();
            System.out.println("클라이언트 요청: " + request);

            out.println("서버 응답: Hello Client!");

            clientSocket.close(); // 연결 종료
        }
    }
}
```