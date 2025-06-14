package com.step04.problem08;

import static com.step04.problem08.SortType.*;

public class RuleOfBiodoem08 {
    public static void main(String[] args) {
//        Book 생성 시나리오
        Book b1 = new Book("파이썬 마스터", "한송희", "2020-01-01");
        Book b2 = new Book("자바의 구름", "제임스밥", "2018-05-05");
        Book b3 = new Book("에너지 플로우", "키네틱스", "2019-08-15");
        Book b4 = new Book("화성에서의 기억", "한송희", "2021-03-03");
        Book b5 = new Book("야채의 비밀", "송은정", "2017-10-10");

//        Library 생성 시나리오
        Library lb = new Library();
//        Library에 Book등록 시나리오
        lb.addBook(b1);
        lb.addBook(b2, b3, b4, b5);
//        도서 대출 성공 시나리오
        lb.borrowBook("야채의 비밀");
        lb.borrowBook(b4);
//        도서 대출 실패 시나리오
        lb.borrowBook("야채의 비밀"); // 대출 중인 도서 대출 시도
        lb.borrowBook(new Book("야채의 시크릿", "송은정", "2017-10-10")); // 없는 도서 대출 시고
//        도서 반납 성공 시나리오
        lb.returnBook("야채의 비밀");
//        도서 반납 실패 시나리오
        lb.returnBook("나의 비밀");

        lb.getSortedBooks(TITLE);

        lb.getSortedBooks(AUTHOR);

        lb.getSortedBooks(PUBLISHED_DATE);

        lb.getSortedBooks(AVAILABILITY);

        lb.getSortedBooks(LAST_BORROWED_DATE);

    }
}
