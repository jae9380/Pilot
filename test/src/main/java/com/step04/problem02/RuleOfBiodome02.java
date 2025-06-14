package com.step04.problem02;

import com.step04.problem02.model.Book;
import com.step04.problem02.model.Manager;
import com.step04.problem02.model.User;

public class RuleOfBiodome02 {
    public static void main(String[] args) {

        LibraryService library = new Library();

//        멤버 등록 시나리오
        Manager manager = (Manager) ((Library) library).createUser("세이코", true);
        User member1 = ((Library) library).createUser("메리",false);
        User member2 = ((Library) library).createUser("만옥",false);

//        매니저를 통한 도서 등록 시나리오
        Book book1 = manager.addBook("자바의 구름", "제임스밥", library);
        Book book2 = manager.addBook("파이썬 마스터", "한송희", library);
        Book book3 = manager.addBook("에너지 플로우", "키네틱스", library);
        Book book4 = manager.addBook("화성에서의 기억", "한송희", library);
        Book book5 = manager.addBook("야채의 비밀", "송은정", library);

//        도서 대여 성공 시나리오
        member1.borrowBook(book1);

        Book book6 = manager.addBook("자료구조의 언덕", "황수", library);
        Book book7 = manager.addBook("그곳에 가", "한송희", library);

//        도서 대여 실패 시나리오
        member2.borrowBook(book1);

//        도서 반납 성공 시나리오
        member1.returnBook(book1);

        manager.borrowBook(book4);

//        저자 기준으로 책 리스트 출력
        ((Library) library).getBooksByAuthor("한송희");
    }
}
