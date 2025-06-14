package com.step04.problem02;

import com.step04.problem02.model.Book;
import com.step04.problem02.model.Manager;
import com.step04.problem02.model.Member;
import com.step04.problem02.model.User;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private int userSequence = 1;
    private int bookSequence = 1;

    private User manager;

    @Override
    public Book addBook(String title, String author) {
        String isbn = String.format("%04d", bookSequence++);
        Book book = new Book(isbn, title, author);

        books.add(book);
        System.out.printf("관리자 \"%1$s\"님이 새로운 책을 추가 합니다.\n\t \"%2$s\" - \"%3$s\"\n", manager.getName(), title, author);
        return book;
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    public User createUser(String name, boolean isItManager) {
        String userId = String.format("U%03d", userSequence++);
        User user;
        if (isItManager) {
            user = new Manager(userId, name);
            System.out.printf("새로운 관리자 \"%s\"를 등록 합니다.\n", name);
            manager = user;
        }else {
            user = new Member(userId, name);
            System.out.printf("새로운 이용자 \"%s\"를 등록 합니다.\n", name);
        }
        users.add(user);

        return user;
    }

    public void getBooksByAuthor(String author) {
        books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .forEach(book -> System.out.printf("*\t제목 : %1$s \t 저자 : %2$s \t 대여 가능 여부 : %3$s\n", book.getTitle(), book.getAuthor(), book.isBorrowed() ? "불가능" : "가능"));
    }
}
