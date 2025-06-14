package com.step04.problem02.model;

import com.step04.problem02.LibraryService;
import com.step04.problem02.model.port.BookManageable;

public class Manager extends User implements BookManageable {
    public Manager(String userId, String name) {
        super(userId, name);
    }

    @Override
    public Book addBook(String title, String author, LibraryService library) {
        return library.addBook(title, author);
    }

    @Override
    public void removeBook(Book book, LibraryService library) {
        library.removeBook(book);
    }
}
