package com.library.service.impl;

import com.library.dao.BookDao;
import com.library.dao.UserDao;
import com.library.exception.LibraryServiceException;
import com.library.model.Book;
import com.library.model.User;
import com.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final UserDao userDao;

    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public Book createBook(Book book) {
        bookDao.save(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        bookDao.findById(book.getId());
        if (book==null)
            throw new LibraryServiceException("Record with provided id is not found");
        book.setName(book.getName());
        book.setAuthor(book.getAuthor());
        return bookDao.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        bookDao.findAll();
        return null;
    }

    @Override
    public Book deleteBook(Book book) {
     bookDao.delete(book);
        return book;
    }

    @Override
    public Book takeBook(Long bookId, Long userId) {
        Book book = bookDao.findById(bookId).get();
        if (book.getOwner().equals(null)) {
            User user = userDao.findById(userId).get();
            book.setOwner(user);
        }else {
            System.out.println("This book is already taken ");
        }
        return book;

    }
    @Override
    public Book returnBook(Long bookId){
        Book book = bookDao.findById(bookId).get();
        User user = book.getOwner();
        user.getBookList().remove(book);
        return book;

    }

}