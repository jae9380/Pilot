# SOLID

`SOLID`는 객체 지향 언어로 프로그래밍을 할 때 지켜야 하는 5가지의 설계 원칙 내용이다.     
각각의 원칙을 철저히 지키면 전체적인 코드들은 변경에 용이해지고, 유지 및 보수에 있어 수월한 작업이 가능해지는 장점을 갖고 있다.


## S -  Single Responsibility Principle (단일 책임 원칙)

하나의 클래스는 하나의 책임만을 갖고 있어야 한다는 원칙이다.
즉, 클래스를 변경하는 이유는 하나를 가져야 한다. 이를 통해 클래스가 변경이 되어도 다른 기능에 미치는 영향을 최소화할 수 있다.

Report라는 클래스가 있고 해당 클래스는 보고서를 출력하고 저장하는 두가지 책임을 갖고 있다고 하자
```java
class Report {
	void printReport() {
    // 출력 로직
    }
    
    void saveToFile(String fileName) {
    // 저장 로직
    }
}
```
단일 원칙에 따라 두가지 책임을 갖고있기 때문에 하나의 클래스는 하나의 책임만 갖도록 수정한다.
```java
class Report {
	void printReport() {
    // 출력 로직
    }
}

class ReportSaver {   
    void saveToFile(String fileName, Report report) {
    // 저장 로직
    }
}
```
위 코드들에서 책임을 구분하는 기준은 **변경의 이유**이다.

수정된 예제 코드를 확인하면 출력 로직이 변경이 되면 `Report`를 변경을 하고, 저장 방식이 변경이 되면 `RepotySaver`만을 변경한다.

## O - Open/Closed Principle (개방/폐쇄 원칙)
소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에는 열려 있어야 하며, 변경에 있어서는 반대로 닫혀 있어야 한다. 이를 위해 추상화와 상속 등의 개냠을 활용할 수 있다.

```java
abstract class Shap{
	abstract void draw();
}

class Circle extends Shape {
	void draw() {
    	System.out.println("원 그리기");
    }
}

class Square extends Shape {
	void draw() {
    	System.out.println("정사각형 그리기");
    }
}

class ShapeDrawer {
	void draw(Shape shape) {
    	shape.draw();
    }
}
```
ShapeDrawer 클래스는 확장에 열려있고, 변경에는 닫혀있다.

확장에는 열려 있고 변경에 닫혀 있는 이유는 추상 클래스나 인터페이스를 정의하고, 구현체를 추가하는 방식으로 확장을 유도한다. 그렇기 때문에 기존 코드에 대한 수정 없이 확장이 가능하기 때문이다.

그렇기 떄문에 새로운 Shape 유형이 추가 되더라도 ShapeDrawer 클래스를 수정 없이 구현체만 추가적으로 구현하면 된다.

## L - Liskov Substitution Principle (리스코프 치환 원칙)
하위 타입의 객체는 상위 타입의 객체를 대체할 수 있어야 한다는 원칙이다.
상위 클래스의 객체를 하위 클래스 객체로 대체하여도 시스템의 동작에 영향을 미치지 않아야 한다.
이 원칙은 상속 구조의 올바른 사용을 보장한다.

```java
class Brid {
	void fly() {
    	System.out.println("새가 날다");
    }
}

class Ostrich extends Brid {
	void fly() {
    	throw new UnsupportedOperationException();
    }
}
```
타조 클래스는 새의 하위 클래스다. 그러나 타조 클래스는 fly 메소드를 지원하지 않으므로, 새 타입을 타조로 대체하는 경우는 리스코프 치환의 원칙에 위배가 된다.

그렇기 떄문에 `Flyable`을 구현하여 이를 분리한다.
```java
interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    public void fly() {
        System.out.println("참새가 납니다");
    }
}

class Ostrich {
    // 날 수 없음
}
```


## I - Interface Segregation Principle (인터페이스 분리 원칙)
사용하지 않는 인터페이스는 구현하지 않아야 한다는 원칙이다.
인터페이스를 작고 구체적으로 유지하여 클라이언트가 자신이 사용하지 않는 메소드에 의존하지 않도록 해야한다.

```java
interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {
    public void work() {
        // 작업 수행
    }
    
    public void eat() {
        // 식사 수행
    }
}

class RobotWorker implements Worker {
    public void work() {
        // 작업 수행
    }
    
    public void eat() {
        // 로봇은 식사가 필요 없으므로, 이 메소드 구현은 부적합
    }
}
```
Worker 인터페이스는 work와 eat 메소드 두가지를 갖고 있다. 그러나 RobotWorker는 eat을 구현할 필요가 없다.
그렇기 때문에 인터페이스는 기능 단위로 구분하여 사용 해야 한다.

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Worker implements Workable, Eatable {
    public void work() {
        // 작업 수행
    }

    public void eat() {
        // 식사 수행
    }
}

class RobotWorker implements Workable {
    public void work() {
        // 작업 수행
    }
}
```
이 처럼 수정을 하면 로봇은 더 이상 사용하지 않는 인터페이스 메서드를 구현하지 않아도 된다.

## D - Dependency Inversion Principle (의존성 역전 원칙)
고수준 모듈은 저수준 모듈에 의존해서는 안되며, 둘 다 추상화에 의존해야 한다는 원칙이다.

추상화는 세부사항에 의존해서는 안되며, 세부 사항이 추상화에 의존을 해야한다. 이 원칙을 통하여 의존성 방향을 역전시켜 변경에 더 유연하게 대응이 가능하다.

```java
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("전구를 켭니다");
    }
    
    public void turnOff() {
        System.out.println("전구를 끕니다");
    }
}

class Switch {
    private Switchable device;
    
    public Switch(Switchable device) {
        this.device = device;
    }
    
    void toggle() {
        // 토글 로직
        // device 상태를 변경
    }
}

// ---- 실행부 ----
Switchable bulb = new LightBulb();
Switch mySwitch = new Switch(bulb);

```
Switch 클래스는 Switchable 인터페이스를 통해 LightBuld 클래스에 의존한다.
이는 고수준 모듈 (Switch)과 저수준 모듈 (LightBulb)사이의 직접적인 의존 관계를 제거하며, Switch클래스를 다양한 Switchable 구현체에 대해 사용할 수 있게 하여 의존선을 역전 원칙에 따른다.

**“실제로는 LightBulb라는 구현체가 사용되지만, Switch 클래스는 오직 Switchable이라는 추상 타입에만 의존하므로 DIP 원칙을 지킨 구조입니다. 이 덕분에 Switch는 다양한 구현체로 손쉽게 교체가 가능하다.”**

---

## 주어진 예제 코드에서 SOLID위반 찾기
### 1. SRP
```java
abstract class User {
// ...
    public void borrowBook(Book book) {
        if(!book.isBorrowed) {
            book.isBorrowed = true;
        }
    }

    public void returnBook(Book book) {
        if(book.isBorrowed) {
            book.isBorrowed = false;
        }
    }

 abstract void addBook(Book book, Library library);
 abstract void removeBook(Book book, Library library); 
}
```

`User`클래스에서 대여, 반납, 추가, 삭제에 대한 책임을 갖고 있다.  두 개 이상의 독립적인 기능 또는 책임이 있다고 판단 된다. 따라서 **기능별로 클래스 또는 인터페이스로  분리**해야 단일 책임 원칙을 지킬 수 있을 것이라 생각한다.

### 2. OCP

```java
// Library
public void addMember(Member member) {
    users.add(member);
}

public void addManager(Manager manager) {
    users.add(manager);
}
```

해당 부분에서 `Member` 와 `Manager`를 구분하여 따로 처리하고 있다는 것을 확인할 수 있다.    
그러면 새로운 `User`하위 객체가 생기면 `add___()`를 추가적으로 생성을 해야 한다는 것을 파악할 수 있다.
이는 변경에 있어서 닫혀있지 않기 때문에 `OCP`를 위반한다고 판단했다.
```java
public void addUser(User user) {
    users.add(user);
}
```
변경에 닫혀있기 위해서 상위 타입으로 설정하여 추가적인 하위 타입이 생성되어도 추가적으로 변경 없도록 수정 했다.

### 4. ISP
```java
// User
abstract void addBook(Book book, Library library);
abstract void removeBook(Book book, Library library); 

// Member
public void addBook(Book book, Library library) {
    System.out.println("Member can't add book");
  }
public void removeBook(Book book, Library library) {
    System.out.println("Member can't remove book");
  }

// Manager
public void addBook(Book book, Library library) {
    library.addBook(book);
  }
public void removeBook(Book book, Library library) {
    library.removeBook(book);
  }

```

각각의 하위 클래스들은 상위 클래스의 추상 메서드를 구현을 한 상태이다.     
그런데 멤버 클래스에서는 `addBook`, `removeBook`을 반드시 구현을 해야 하기 때문에 구현을 했지만, 사실상 구현 내용은 아무런 의미가 없다고 판단이 된다.

**ISP**에서는 인터페이스를 작고 구체적으로 유지하여 클라이언트가 자신이 사용하지 않는 메소드에 의존하지 않도록 해야한다고 설명을 했다. 그렇기 때문에 **ISP**를 위반했다고 생각한다.


