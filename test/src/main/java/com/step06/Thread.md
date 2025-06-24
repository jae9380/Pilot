
# 멀티 쓰레드
운영체제에서 실행 중인 하나의 어플리케이션을 **프로세스**라고 부른다. 사용자가 어플리케이션을 실행하면 운영체제로부터 실행에 필요한 메모리를 할당 받아서 어플리케이션의 코드를 실행하는데 이는 프로세스이다.

## Thread
운영체제에서 두 가지 이상의 작업을 동시에 처리하는 멀티 태스킹(Multi tasking)을 할 수 있도록 CPU 및 메모리 자원을 프로세스마다 적절히 할당을 하고, 병렬로 실행을 한다.

멀티 태스킹은 꼭 멀티 프로세스를 뜻하는 것은 아니다. 한 프로레스 내에서 멀티 태스킹을 할 수 있도록 만들어진 어플리케이션 또한 존재한다.
여기서 하나의 프로세스가 두 가지 이상의 작업을 처리할 수 있는 이유는 바로 **멀티 쓰레드**가 가능하게 하기 떄문이다.

**쓰레드(Thread)**는 사전적인 의미로 한 카닥의 실이라는 뜻이다. 한 가지 작업을 실행하기 위해서 순차적으로 실행할 코드를 실 처럼 이어놓았다고 해서 유래 되었다고 한다.

![](https://i.postimg.cc/ZKqSJ5ff/scode-mtistory2-fname-https-blog-kakaocdn-net-dn-b-Fgmwc-btrb7zq7-RVE-Mk-F8-Kmpu-Lq-UBzqv3-Ky7-U31-img.jpg)

하나의 쓰레드는 하나의 코드 실행 흐름이기 때문에 한 프로세스 내에서 쓰레드가 2개라면 2개의 코드 실행 흐름이 생신다는 의미이다.

멀티 프러레스는 운영체제에 따라 할당받은 자신의 메모리를 갖고 실행하기 때문에 각 프로세스는 서로 독립적이게 된다. 따라서 **하나의 프로레스에서 오류가 발생하게 된다면, 다른 프로세스에게 영향을 미치지 않는다.** 하지만**멀티 쓰레드는 하나의 프로세스 내부에서 생성되기 때문에 하나의 쓰레드가 예외를 발생시키면 프로세스 자체가 종료될 수 있어 다른 쓰레드에 영향을 주게 된다.**

## Main Thread
자바의 모든 어플리케이션은 **메인 쓰레드**가 `main()`메서드를 실행하면서 시작을 한다. 메인 쓰레드는 메인 메서드 전체를 순차적으로 실행을 한다.

```java
public static void main(String[] args) {	//	⬇️
	String data = null;						//	⬇️		코드의 실행 흐름
	if(...) {								//	⬇️			=
	}										//	⬇️		  쓰레드
	...										//	⬇️
}								
```

메인 쓰레드는 필요에 따라 작업 쓰레드를 만들어 병렬로 코드를 실행할 수 있다.

## 작업 쓰레드 생성과 실행
어플리케이션을 개발하면서 몇 개의 작업을 병렬로 실행할지 경정을 하고 각 작업별로 쓰레드를 생성해야 한다.

어떤 자바 어플리케이션이건 메인 쓰레드는 반드시 존재하기 때문에 메인 작업 외 추가적인 병렬 작업의 수 만큼 쓰레드를 생성하면 된다.

### Thread 상속
`java.lang.Thread` 클래스를 직접적으로 상속을 받는다.
**Thread** 클래스는 **Runnable** 인터페이스를 구현한 클래스이므로, `run()` 메서드를 **오버라이딩하여 작업 쓰레드가 실행할 코드를 작성**해야 한다.

Thread는 직접 상속받기 때문에 **객체 생성 후 곧바로 start() 메서드를 호출해 실행**하면 된다.
```java
public class MyThread extends Thread {
	@Override
	public void run() {
		...
	}
}
```

```java
Thread thread = new MyThread();
thread.start();
```

해당 방식은 간단하다는 장점이 존재하지만, **다중 상속이 불가능**하다는 단점이 존재한다. 그렇기 떄문에 일반적으로 권장하는 않는다고 한다.

추가적으로 익명 객체 사용하여 코드를 절약할 수 있다. 익명 객체를 사용할 경우에는 Thread 클래스 자체를 인라인으로 정의할 수 있다.

```java
Thread thread = new Thread() {
	@Override
	public void run() {
		...
	}
};
```

#### 예제 코드
메인 쓰레드에서는 출력을 하고, 작업 쓰레드에서 비프음이 발생하도록 하겠다.

```java
public class BeepThread extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}
```

```java
public class Example {
	public static void main(String[] args) {
		Thread thread = new BeepThread();
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}
```

### Runnnable 구현
`java.lang.Thread` 클래스로 부터 작업 쓰레드 객체를 직접 생성하려면 다음과 같이 **Runnable**을 매개값으로 갖는 생성자를 호출해야 한다.

```java
Thread threa = new Thread(Runnable target);
```

Runnable은 작업 스레드가 실행할 수 있는 코드를 갖고 있는 객체라고 해서 붙여진 이름이다.

Runnable은 인터페이스 타입이기 때문에 구현 객체를 만들어 대입해야 한다. **Runnable에는 `run()`메서드가 하나 정의**되어 있는데, **구현 클래스는 해당 메서드를 재정의 하여 작업 쓰레드가 실행할 코드를 작성**해야 한다.

```java
class Task implements Runnable {
	@Override
	public void run() {
		...
	}
}
```

Runnable 구현 객체를 생성한 후, 이것을 매개값으로 Thread 생성자를 호출해야 작업 쓰레드가 생성되는 것이다.

추가적으로 코드를 절약하기 위해서 익명 객체 그리고 람다를 사용하여 코드를 절약할 수 있다.

```java
Thread thread = new Thread( new Runnable() {
	@Override
	public void run() {
		....
	}
});
```

```java
Thread thread = new Thread(() -> {
	...
});
```

#### 예제 코드

```java
public class BeepTask implements Runnable {
	@Override	
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try{
				thread.sleep(500);
			} catch(Exception e) {}	
		}
	}
}
```

```java
public class Example{
	public static void main(String[] args) {
		Runnable beeptask = new BeepTask();
		Thread thread = new Thread(beeptask);
		thread.start();

		for(int i = 0; i < 5; i++) {
			System.out.println("띵!");
			try{
				thread.sleep(500);
			} catch(Exception e) {}
		}
	}
}
```

### ExecutorService 사용
**ExecutorService**는 자바에서 **쓰레드를 직접 생성하지 않고 작업을 비동기로 처리할 수 있는 고수준의 API**이다. 쓰레드 풀을 생성하고 `execute()` 또는 `submit()` 메서드를 사용하여 작업을 전달하고 병렬 처리할 수 있도록 한다.

쓰레드 풀을 생성하려면 **Executors** 클래스의 정적 메서드를 사용한다.
```java
ExecutorService executor = Executors.newFixedThreadPool(int nThreads);
```


바로 앞에서는 쓰레드 풀을 생성하고  `execute()` 또는 `submit()` 을 사용하여 작업을 전달한다고 했는데 이 부분에 대해서 알아보자



`execute()`와 `submit()` 메서드는 유사해 보이지만, 사실 각 메서드는 **동작 방식과 목적** 부분에서는 명확한 차이가 존재한다.

이 둘은 **Runnable** 또는 **Callable** 객체를 쓰레드 풀에 넘겨 작업을 실행하는 방식이지만, 각 방법은 용도와 리턴 타입이 다르기 떄문에 적절하게 어떤 메서드를 사용할 지 선택을 해야 한다.

일단 두 방법에 대한 공통점을 먼저 짚고 넘어가자
* 둘 다 **ExecutorService**를 통하여 작업을 비동기로 실행
* 둘 다 인자로 **Runnable**또는 **Callable**을 받는다.
* 내부적으로 쓰레드 풀의 쓰레드가 작업을 수행한다.


차이점은 다음과 같다.

| **항목** | **execute()** | **submit()** |
|:-:|:-:|:-:|
| 받을 수 있는 타입 | Runnable | Runnable 또는 Callable |
| 리턴값 | 없음 (void) | Future<T> 객체 반환 |
| 예외 처리 | 예외 발생 시 바로 스레드 종료, 전달 어려움 | 예외가 Future.get() 시점에 감지됨 |
| 결과 확인/취소 | 불가능 | 가능 (Future 활용) |
| 주요 용도 | 단순한 백그라운드 실행 | 결과 반환, 상태 추적 필요할 때 |

각 메서드 사용 방법
* executor.execute(Runnable task)
  `execute()` 메서드는 인자로 **Runnable** 객체를 받아야 한다.
  해당 방법은 단순한 작업을 수행하고 끝나게 된다. 그리고 반환값이 없기 떄문에 결과값이 필요 없는 작업에서 사용이 된다.
```java
ExecutorService executor = Executors.newFixedThreadPool(1);

executor.execute(new Runnable() {
    @Override
    public void run() {
        System.out.println("Runnable 실행 중...");
    }
});

executor.shutdown();
```

* executor.submit(Runnable or Callable)
  `submit()`의 경우에는 인자로 **Runnable**과 **Callable**을 받는다. 그런데 어떤 인자를 주느냐에 따라 반환값을 전달 하느냐가 결정이 된다.
  만약 **Runnable**을 전달하면 반환값이 없는  **Future**, 반대로 **Callable**을 전달하게 되면 결과값을 반한하는 **Future**

```java
Future<?> future = executor.submit(new Runnable() {
    @Override
    public void run() {
        System.out.println("Runnable 작업 실행");
    }
});

future.get();
```

```java
Callable<String> task = () -> {
    Thread.sleep(1000);
    return "작업 완료!";
};

Future<String> future = executor.submit(task);
String result = future.get();
```

모든 작업이 끝났을 때 반드시 `shutdown()` 메서드를 사용하여 쓰레드 풀을 종료해야 한다._

#### 예제 코드

```java
public class Example {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Runnable beepTask = new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (Exception e) {}
				}
			}
		};

		executor.execute(beepTask);

		for (int i = 0; i < 5; i++) {
			System.out.println("띵!");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}

		executor.shutdown();
	}
}
```