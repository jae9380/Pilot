package com.step04.problem08;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
    private ArrayList<Book> list;

    public Library() {
        this.list = new ArrayList<>();
        System.out.println("도서관 시스템이 생성되었습니다.");
    }

    public boolean addBook(Book book) {
        System.out.printf("[LIBRARY] \"%s\"가 도서 목록에 추가되었습니다.\n", book.getTitle());
        return list.add(book);
    }

    public boolean addBook(Book... books) {
        for (Book book : books) {
            addBook(book);
        }
        return true;
    }

    public void borrowBook(String title) {
        Book book = null;
        try{
            book = findBook(title);
            book.borrow();
            System.out.printf("[LIBRARY] \"%1$s\" 도서를 대출 하였습니다. 도서 대출 날짜 갱신 완료\n", title);
        }catch (IllegalArgumentException e1) {
            System.out.println(e1.getMessage());
            return;
        }catch (IllegalStateException e2) {
            System.out.println(e2.getMessage());
            System.out.printf("[LIBRARY] \"%1$s\" 도서를 대출을 실패하였습니다.\n", title);
        }
    }

    public void borrowBook(Book book) {
        try {
            containsBook(book);
            book.borrow();
            System.out.printf("[LIBRARY] \"%1$s\" 도서를 대출 하였습니다.\n", book.getTitle());
        } catch (IllegalArgumentException e1) {
            System.out.println(e1.getMessage());
            return;
        } catch (IllegalStateException e2) {
            System.out.println(e2.getMessage());
            System.out.printf("[LIBRARY] \"%1$s\" 도서를 대출을 실패하였습니다.\n", book.getTitle());
        }
    }

    public void returnBook(String title) {
        Book book;
        try {
            book = findBook(title);
            book.returnBook();
            System.out.printf("[LIBRARY] \"%1$s\" 도서를 반납 하였습니다.\n", title);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.printf("[LIBRARY] \"%1$s\" 도서를 반납을 실패하였습니다.\n", title);
        }
    }


    public ArrayList<Book> getSortedBooks(SortType type) {
        ArrayList<Book> sorted = new ArrayList<>(list); // 원본 리스트는 변경하지 않음
        System.out.printf("-------- %s 기준 정렬 리스트 --------\n", type.getKorean());
        switch (type) {
            case TITLE:
                Collections.sort(sorted); // Comparable<Book> 기준
                break;
            case AUTHOR:
                sorted.sort(Book.sortByAuthor());
                break;
            case PUBLISHED_DATE:
                sorted.sort(Book.sortByPublishedDate());
                break;
            case AVAILABILITY:
                sorted.sort(Book.sortByAvailability());
                break;
            case LAST_BORROWED_DATE:
                sorted.sort(Book.sortByLastBorrowedDate());
                break;
        }
        for (Book book : sorted) {
            book.printInfo();
        }
        System.out.println("------------------------");
        return sorted;
    }
    
    private Book findBook(String title) throws IllegalArgumentException{
        return list.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[SYSTEM ERROR] 제목에 해당하는 도서를 찾을 수 없습니다."));
    }
    private boolean containsBook(Book book) throws IllegalArgumentException{
        boolean exists = list.stream()
                .anyMatch(b -> b.equals(book));
        if (!exists) {
            throw new IllegalArgumentException("[SYSTEM ERROR] 해당 도서는 시스템에서 관리하지 않습니다.");
        }
        return exists;
    }
}
