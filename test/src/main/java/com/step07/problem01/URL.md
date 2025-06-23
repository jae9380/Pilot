#Java
# **URL - Uniform Resource Locator**

자바에서 사용할 수 있는 **URL**클래스에 대해서 알아보자
> ## java.net.URL

`java.net.URL` 클래스는 단순하게 웹 주소를 표현하는 것 이상으로 **다양한 종류의 리소스 위치를 표현하고 다룰 수 있도록 설계된 범용적인 클래스**이다.

자바에서 지원하는 `URL` 클래스는 **Uniform Resource Locator**를 표현하는 클래스이다.  이는 웹, 파일 등 다양한 리소스에 접근할 수 있도록 지원하는 API이다. 그렇기 때문에 **’범용적인 클래스’**라고 소개를 한 것이다.

## URL

Uniform Resource Locator은 **네트워크 상의 자원의 위치를 식별하고, 해당 자원에 접근하기 위한 방법을 명시한 문자열**이다.    
즉, “무엇을 가리키는가?”와 “어떻게 접근하는가”를 같이 포함한 **표준 주소 체계**이다.

## 표준 형태

URL은 아래와 같이 RFC 3986에 따라 공통적인 구조를 따르고 있다.
`<protocol>://<userInfo>@<host>:<port>/<path>?<query>#<fragment>`

해당 표준 구조에서 각 요소에 대한 정보는 표로 작성했다.  

| **구성 요소** | **예시** | **설명** |
|:-:|:-:|:-:|
| protocol | http, https, file, ftp | 접근 방식 |
| userInfo | user:password | 인증 정보 (보통 생략) |
| host | www.example.com 또는 localhost | 서버 또는 파일 경로의 호스트 |
| port | 80, 443, 21, 생략 가능 | 포트 번호 |
| path | /index.html, /img/logo.png | 리소스 경로 |
| query | id=1&name=test | 요청 파라미터 |
| fragment | #top | 문서 내부 위치 (북마크) |

### **리소스별 URL 예시**

각 유형별 작성되는 URL의 형태는 아래와 같다.

* 웹
  `https://www.example.com:443/index.html?query=java#top`

* 로컬 파일
  `file:///C:/Users/Me/file.txt`

* FTP 서버
  `ftp://user:pass@ftp.example.com:21/files/file.txt`

* JAR  파일 내부
  `jar:file:/path/to/app.jar!/com/example/Main.class`

* 클래스 패스 리소스
  `(Java에서) getClass().getResource("data.txt") → file:/.../data.txt 또는 jar:file:/...!/data.txt`

각 유형별 작성되는 URL을 보면 뭔가 표준 URL과는 사뭇 다르다고 생각될 수 있다.

하지만, 각 유형별 작성된 URL은 모두 다 같은 형태의 URL이고 다르게 보이는 것 뿐이다.

URL은 모두 `RFC 3986` 구조를 따르고 있다. 하지만 **스킴에 따라 필요한 정보만을 포함**하는 방식으로 동작을 하기 때문에 각 형태의 URL이 다르게 보일 뿐이다.

* FILE의 경우에는 host나 port가 필요 없기 때문에 생략
* jar의 경우 URL은 JAR 파일 안의 리소스를 다루기 떄문에 중첩된 URL 구조를 사용
* ftp의 경우 인증 정보(userInfo)를 명시적으로 포함하는 경우가 존재

따라서 **표준에서 정해진 형식 중에서 어떤 요소를 사용하느냐에 따라 생긴 차이일 뿐, 사실 하나의 표준을 따른다**.

## 주요 기능 목록

* ### URL 구성 추출
  URL 객체를 생성한 후 그 안의 구성 요소를 쉽게 분해할 수 있는 메서드들입니다.
* 
  | **메서드** | **설명** | **예시 (https://user:pass@www.example.com:8080/path/page.html?query=abc#section)** |
  |:-:|:-:|:-:|
  | getProtocol() | 스킴 (프로토콜) 반환 | "https" |
  | getHost() | 호스트 이름 반환 | "www.example.com" |
  | getPort() | 명시된 포트 반환 (없으면 -1) | 8080 |
  | getDefaultPort() | 해당 프로토콜의 기본 포트 반환 | 443 (https), 80 (http) |
  | getFile() | 경로 + 쿼리 반환 | "/path/page.html?query=abc" |
  | getPath() | 경로만 반환 | "/path/page.html" |
  | getQuery() | 쿼리 스트링 반환 | "query=abc" |
  | getRef() | URL 내 북마크(# 뒤) 반환 | "section" |
  | getUserInfo() | 사용자 인증 정보 반환 | "user:pass" |
  | getAuthority() | 호스트:포트 및 인증정보 포함한 권한 부분 | "user:pass@www.example.com:8080" |

* ###  **URL 객체 상태 변환 / 문자열 변환**

| **메서드** | **설명** | **예시** |
|:-:|:-:|:-:|
| toString() | URL을 문자열로 변환 | "https://www.example.com/path" |
| toExternalForm() | 외부 표현 문자열 반환 | "https://www.example.com/path" |
| toURI() | URL → java.net.URI 로 변환 | new URI(...) 형태로 사용 가능 |

* ### **리소스에 접근**
  해당 URL이 가리키는 리소스(웹 페이지, 파일 등)에 실제로 접근하는 기능입니다.

  | **메서드** | **설명** | **주의사항** |
  |:-:|:-:|:-:|
  | openConnection() | URLConnection 객체 반환 (헤더 조작, 캐시 설정 가능) | 네트워크 연결 필요 |
  | openStream() | InputStream 반환 (리소스 내용을 바로 읽음) | 네트워크 연결 또는 파일 열기 |
  | getContent() | 리소스 내용을 객체로 반환 | 자주 사용되지 않음, 구현체마다 다름 |

* ### **리소스 존재 여부 확인 및 에러 처리**

| **방식** | **설명** |
|:-:|:-:|
| try-catch로 예외 처리 | MalformedURLException (URL 형식 오류), IOException (연결 실패 등) |
| getClass().getClassLoader().getResource() | 클래스패스 내 리소스 탐색 시 사용 |
