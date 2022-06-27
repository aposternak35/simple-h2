package org.aposternak35.app.controller;

import org.aposternak35.app.service.BookService;
import org.aposternak35.app.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    private List getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{uid}")
    private Book getBook(@PathVariable("uid")long uid){
        return bookService.getBookById(uid);
    }
    @DeleteMapping("/{uid}")
    private void deleteBook(@PathVariable("uid")long uid){
        bookService.delete(uid);
    }
    @PostMapping("/")
    private long saveBook(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return book.getUid();
    }
}
