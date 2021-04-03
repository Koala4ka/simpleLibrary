package com.library.controller;


import com.library.dao.BookDao;
import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Optional<Book> getBookById(@PathVariable(value = "id") Long id) {
        return bookDao.findById(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);

    }

    @DeleteMapping("/deleteBook/{id}")
    public Book deleteBook(@RequestBody Book book) {
        return bookService.deleteBook(book);
    }
    @PutMapping("/tookBook/{id}")
    public Book tookBook(@PathVariable(value ="id") Long bookId, @RequestParam Long userId){
        return bookService.takeBook(bookId,userId);

    }
    @PutMapping("/returnBook/{id}")
    public Book returnBook(@PathVariable(value ="id") Long bookId){
        return bookService.returnBook(bookId);
    }

}
