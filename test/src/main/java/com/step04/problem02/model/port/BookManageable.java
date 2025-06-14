package com.step04.problem02.model.port;

import com.step04.problem02.LibraryService;
import com.step04.problem02.model.Book;

public interface BookManageable {
    Book addBook(String title, String author, LibraryService library);
    void removeBook(Book book, LibraryService library);
}
