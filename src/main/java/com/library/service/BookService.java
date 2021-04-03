package com.library.service;

import com.library.model.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book updateBook(Book book);

    List<Book> getAllBooks();

    Book deleteBook(Book book);

    Book takeBook(Long bookId, Long userId);

    Book returnBook(Long bookId);


}

