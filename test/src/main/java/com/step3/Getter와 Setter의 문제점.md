#coding #OOP #Getter/Setter
# Getter와 Setter의 이중성

## 객체지향 설계에서 정보 은닉의 중요성

정보 은닉(Information Hiding)은 객체지향 설계 원칙 중 하나로, **캡슐화(Encapsulation)**와 연관되어 있다.
보통 객체지향은 **4대 핵심 원칙**(추상화, 캡슐화, 상속, 다형성) 중 캡슐화에 포함된 개념으로 본다. 

> 그래서 정보 은닉은 왜 해야 하나요?

객체를 설계할 때 내부 상태를 외부에 노출하게 된다면, 그 객체는 더 이상 스스로의 상태를 제어할 수 없는 지경이 된다. 이는 외부에서 마음대로 객체의 속성을 읽거나 수정, 삭제 등을 하면서 객체의 자율성이 사라지고 시스템 전체의 복잡도가 증가하는 문제로 이어진다. 이러한 상황에서 유지보수 측면을 어렵게 만들며 변경이 잦은 요구사항에 흔들리게 된다.

![](https://i.postimg.cc/vHdp33VD/encapsulation.png)

이러한 문제를 방지하기 위해서 **캡슐화(Encapsulation)**를 통하여 클래스의 속성이나, 함수를 하나로 묶어 외부로 부터 내부 정보를 감싸 은닉하게 된다. 캡슐화로 정보 은닉 뿐만 아니라 외부로 부터 잘못된 접근을 통한 의도하지 않은 정보 수정, 삭제 등으로 보호하는 효과 까지 이어진다. 

## Getter와 Setter의 목적
그럼 정보 은닉과 보호 효과를 위해서 캡슐화를 진행한 객체에서 값을 갖고 오거나 수정을 하기 위해서는 어떻게 해야 하는가…

캡슐화를 진행한 경우 대부분의 필드는 `private` 접근 제어자를 사용한다. 그렇기 때문에 외부에서 직접적으로 필드에 접근을 막고 있다. 그렇기 때문에 `public`접근 제어자인 메서드를 통해 객체의 필드로  접근을 우회하고 있다. 

여기서 `private`필드로의 접근을 도와주는 `public`메서드가 `Getter`,` Setter`이다. 

```java
// Getter/Setter
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// 외부에서 아무 나이 정보를 갖고 온다.
person.getAge(); 
```

## Getter와 Setter의 모순
앞서 정보 은닉의 중요성과 캡슐화에 대해 이야기했고, `Getter`와 `Setter`가 어떤 목적으로 사용되는지도 살펴보았다. 그런데 여기서 한 가지 의문이 있다.

> 정보 은닉을 한다고 했다. 그런데 왜 외부에서 `Getter`로 값을 가져오고, `Setter`로 값을 수정하는가?
> 그렇다면 진정으로 정보 은닉을 하고 있다고 말할 수 있는가?

객체지향 프로그래밍은 다양한 객체들이 협력하여 하나의 프로그램을 구성하는 방식을 지향한다. 이러한 방식의 장점은 **다른 객체의 내부 구현을 몰라도**, 필요한 역할만 요청하면 된다는 점이다.

하지만 이 장점을 활용하지 않고, **외부에서 객체의 값을 직접 꺼내 로직을 수행하거나 수정한다면** 이는 객체지향적인 방식이라고 보기 어렵다. 결국 객체는 단순한 데이터 저장소로 전락하고, 정보 은닉은 의미를 잃게 된다.

### Getter 문제점
`Gette`은 보통 객체의 필드 값을 확인하기 위해서 사용한다. 그런데 단순한 `Getter` 사용은 객체의 **정보 은닉을 약화** 시키고, **책임을 전과**하는 문제가 발생한다.

예를 들어 인터넷 횸쇼핑에서 주문 금액을 할인하는 서비스를 예를 들어보자
```java
// 도메인 객체
public class Order {
    private int totalAmount;

    public Order(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}

// 서비스 로직
public class DiscountService {
    public void applyDiscount(Order order) {
        int amount = order.getTotalAmount();
        if (amount > 10000) {
            amount -= 1000; // 1,000원 할인
        }
        System.out.println("할인 적용된 금액: " + amount);
    }
}
```
위 코드에서 할인 서비스 클래스의 메서드를 보면 `Getter`을 이용하여 객체의 필드 정보를 갖고와서 서비스 로직 내부에서 할인을 적용하고 있다. 

주문 객체를 보면, 스스로 할인이라는 스스로의 책임을 수행하지 않고 단순히 총 금액만 전달하는 상황이다. 이는 할인을 적용해야 하는 자신의 책임을 서비스 로직에 전과하고 있다.

이러한 문제를 개선하기 위해서는 주문 객체에서 할인을 적용시키는 로직을 넣고, 서비스 로직은 필요한 결과만을 요청하도록 설계를 해야 한다.

```java
// 도메인 로직
public class Order {
    private int totalAmount;

    public Order(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getDiscountedAmount() {
        if (totalAmount > 10000) {
            return totalAmount - 1000;
        }
        return totalAmount;
    }
}

// 서비스 로직
public class DiscountService {
    public void applyDiscount(Order order) {
        int discountedAmount = order.getDiscountedAmount();
        System.out.println("할인 적용된 금액: " + discountedAmount);
    }
}
```

이렇게 수정을 하게 된다면 `Order`객체는 더 이상 단순한 데이터 저장 공간이 아닌, 자신의 상태를 직접 관리하게 되고, 서비스 로직에서 다른 객체의 내부 사정을 알 필요 없이 필요한 값만 호출하게 되면서 객체 지향 프로그래밍에 한 걸음 가까워 졌다.

그리고 추가적인 변경 사항이 생겨도 내부 로직만을 수정하게 되면서 **변경에 강한 구조**가 된다.

### Setter의 문제점 

```java
public class Wallet {
    private int accountBalance;

    public Wallet(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
```
지갑이라는 객체가 있고 계좌 잔액이하는 필드가 있다고 하자. 

```java
Wallet myWallet = new Wallet(5000);
myWallet.setAccountBalance(10000);
```

외부에서 객체를 생성할 때 5,000을 넣었다. 그리고 `Setter`를 사용해서 필드 정보를 10,000으로 수정을 했다. 
그러면 우리가 알 수 있는 내용은 지갑을 생성할 때 5,000원을 넣었다는 것은 명확하게 알고 있다. 하지만 `.setAccountBalance(10000);` 만 보면 계좌에 추가적인 5,000을 넣어서 잔액이 10,000이 되었는지,  더 많은 금액을 넣고 얼마를 사용하고 남은 금액이 10,000인지 자세한 정보를 모르게 된다는 단점이 존재한다. 

이 처럼 단순하게 `Setter`을 사용하게 된다면 객체의 속성이 어떤 이유로 변경이 되었는지 모르게 된다.

추가적으로 출금 같은 동작을 할 때  `Getter`와 같이 `Wallet`은 단순히 값만 저장하고, 스스로의 책임을 서비스 로직에게 떠넘기고 있다.

```java
public void withdraw(long amount) {
	long newBalance = myWallet.getAccountBalance() - amount;
        
    if (newBalance < 0) {
    	throw new IllegalArgumentException("잔액 부족");
	}
        
    account.setBalance(newBalance);
}
```

객체의 필드를 보다 안전하게 수정하기 위해서는 스스로 통제를 해야 하고 스스로의 책임을 다 해야 한다.

```java
public class Wallet {
    private int accountBalance;

    public Wallet(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void withdraw(int amount) {	// Setter
        if (amount <= 0) {
            throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
        }

        if (accountBalance - amount < 0) {
            throw new IllegalArgumentException("잔액 부족");
        }

        this.accountBalance -= amount;
    }

    public int getAccountBalance() {
        return accountBalance;
    }
}
```

```java
Wallet myWallet = new Wallet(5000);
myWallet.withdraw(1000); // 내부에서 유효성 검사를 포함한 로직 수행
```

## 객체의 자율성과 책임 분리
객체 지향 프로그래밍의 핵심은 **데이터와 행위를 하나로 묶고**, 각 객체가 **스스로 상태와 행위에 책임을 다 하는 자율적인 존재**가 되도록 해야 한다. 단순한 `Getter`와 `Setter`사용은 객체 지향 프로그래밍을 무너뜨리고 객체를 단순한 데이터 저장 공간으로 전락시키는 행동이 된다.     

그렇기 때문에 진정한 객체 지향적인 설계를 위해서는 **필드 값을 단순히 노출하거나 변경**하는 방법이 아닌 **명확한 의미가 있는 메서드를 통한 상태 관리와 행동 수행**을 하도록 유도를 해야 한다. 이러한 과정을 토대로 객체는 더욱 견고해지고, 변경에 강해지며, 협력에 유리한 구조로 발전하게 된다.
