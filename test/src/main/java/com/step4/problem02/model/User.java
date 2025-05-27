package com.step4.problem02.model;

public abstract class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.bookLoan();
            System.out.printf("이용자 \"%1$s\"님이 \"%2$s\" 대여 합니다.\n", name, book.getTitle());
        }else System.out.printf("도서 \"%1$s\"는 누군가 대여를 했습니다.\n",  book.getTitle());

    }

    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            book.returnOfTheBook();
            System.out.printf("이용자 \"%1$s\"님이 \"%2$s\" 반납 합니다.\n", name, book.getTitle());
        }else System.out.printf("도서 \"%1$s\"는 이미 도서관에 있습니다.\n",  book.getTitle());
    }

    public String getName() {
        return name;
    }
}
