package com.step2;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome02 {
    public static void main(String[] args) {
        validationInput(args[0]);

        String input = args[0];

        if (isItPalindrome(input)) {
            System.out.println(input);
            return;
        }

        CustomStack<String> customStack = new CustomStack<>();
        for (char c : input.toCharArray()) {
            customStack.push(String.valueOf(c));
        }
        for (int i = 0; i <input.length() ; i++) {
            System.out.print(customStack.pop());
        }


    }
    static void validationInput(String str) {
        if (str.trim().isEmpty()) {
            System.out.println("올바른 문장을 입력해주세요.");
            systemDown();
        }

        if (!str.matches("[a-zA-Z0-9가-힣]+")) {
            System.out.println("영어, 한글, 숫자만 입력할 수 있습니다.");
            systemDown();
        }

        if(str.length() < 2 || str.length() > Math.pow(10,6)) {
            System.out.println("입력가능한 문자열의 길이는 최소 2에서 최대 10^6승 입니다.");
            systemDown();
        }
    }

    static void systemDown() {
        System.exit(1);
    }

    static boolean isItPalindrome(String str) {
        char[] sample = str.toCharArray();
        for (int i = 0; i < sample.length; i++) {
            if (sample[i] != sample[sample.length - i - 1]) return false;
        }
        return true;
    }

    static class CustomStack<T> {
        List<T> customStack;

        CustomStack() {
            this.customStack = new ArrayList<>();
        }

        T push(T item) {
            customStack.add(item);
            return item;

//              실제 Stack 구현 코드
//            public E push(E item) {
//                addElement(item);
//
//                return item;
//            }
        }

        T pop() {
            T output;
            int len = customStack.size();
            output = peek();
            customStack.remove(len - 1);
            return output;

//            실제 Stack 구현 코드
//            public synchronized E pop() {
//                E obj;
//                int len = size();
//                obj = peek();
//                removeElementAt(len - 1);
//                return obj;
//            }

        }
        T peek() {
            int len = customStack.size();

            if (len == 0) throw new IndexOutOfBoundsException();

            return customStack.get(len-1);

//            실제 Stack 구현 코드
//            public synchronized E peek() {
//                int len = size();
//
//                if (len == 0) throw new EmptyStackException();
//
//                return elementAt(len - 1);
//            }
        }

        boolean isEmpty() {
            return customStack.size() == 0 ;

//            실제 Stack 구현 코드
//            public boolean empty() {
//                return size() == 0;
//            }
        }
    }

}