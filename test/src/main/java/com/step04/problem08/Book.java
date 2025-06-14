package com.step04.problem08;

import java.time.LocalDate;
import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private LocalDate publishedDate;
    private boolean isAvailable;
    private LocalDate lastBorrowedDate;

    public Book(String title, String author, String publishedDate) {
        this.title = title;
        this.author = author;
        this.publishedDate = LocalDate.parse(publishedDate);
        this.isAvailable = true;
        this.lastBorrowedDate = null;
        System.out.printf("[BOOK] 제목: %1$s, 저자: %2$s, 출판일: %3$s, 대출 가능 여부: \"가능\", 최근 대출 날짜: \"N/A\"\n",
                title, author, publishedDate);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDate getLastBorrowedDate() {
        return lastBorrowedDate;
    }

    public void borrow() throws IllegalStateException{
        if (!isAvailable) throw new IllegalStateException("[SYSTEM WARRING] 해당 도서는 현재 대출 중 입니다.");
        this.isAvailable = false;
        this.lastBorrowedDate = LocalDate.now();
    }

    public void returnBook() {
        this.isAvailable = true;
    }

    public void printInfo() {
        System.out.printf("제목 - %1$s\t 저자 - %2$-6s\t 출판일 - %3$-6s\t 대출 가능 여부 - %4$-6s\t 최근 대출 일자 - %5$-6s\n"
                ,title,author,publishedDate,isAvailable ? "가능" : "불가능",lastBorrowedDate);
    }


    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }

    // 저자 기준
    public static Comparator<Book> sortByAuthor() {
        return Comparator.comparing(Book::getAuthor);
    }

    // 출판일 기준
    public static Comparator<Book> sortByPublishedDate() {
        return Comparator.comparing(Book::getPublishedDate);
    }

    // 대출 가능 여부 기준
    public static Comparator<Book> sortByAvailability() {
        return Comparator.comparing(Book::isAvailable).reversed();
    }

    // 최근 대출일 최신순
    public static Comparator<Book> sortByLastBorrowedDate() {
        return (b1, b2) -> {
            if (b1.lastBorrowedDate == null && b2.lastBorrowedDate == null) return 0;
            if (b1.lastBorrowedDate == null) return 1;
            if (b2.lastBorrowedDate == null) return -1;
            return b2.lastBorrowedDate.compareTo(b1.lastBorrowedDate);
        };
    }
}
