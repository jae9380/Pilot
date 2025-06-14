package com.step04.problem02.model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isBorrowed;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void bookLoan() {
        isBorrowed = true;
    }

    public void returnOfTheBook() {
        isBorrowed = false;
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;

    }
}
