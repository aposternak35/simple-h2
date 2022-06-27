package org.aposternak35.app.service;

import org.aposternak35.app.domain.Book;
import org.aposternak35.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List getAllBooks(){
        List books=new ArrayList();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }
    public Book getBookById(long uid){
        return bookRepository.findById(uid).get();
    }
    public void saveOrUpdate(Book book){
        bookRepository.save(book);
    }
    public void delete(long uid){
        bookRepository.deleteById(uid);
    }
}
