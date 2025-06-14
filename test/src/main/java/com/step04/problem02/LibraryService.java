package com.step04.problem02;

import com.step04.problem02.model.Book;

public interface LibraryService {
    Book addBook(String title, String author);
    void removeBook(Book book);
}
