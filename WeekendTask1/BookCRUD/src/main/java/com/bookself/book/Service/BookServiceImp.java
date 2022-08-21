package com.bookself.book.Service;

import com.bookself.book.Models.Book;
import com.bookself.book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    private BookRepository bookRepository;
    public BookServiceImp(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }
    @Override
    public Book saveBook(Book book)
    {
        return bookRepository.save(book);
    }
    @Override
    public List<Book>getAllBooks()
    {
        return bookRepository.findAll();
    }
    @Override
    public Book getBookById(int id)
    {
        return bookRepository.findById(id).orElseThrow();
    }
    @Override
    public Book updateBook(Book book, int id)
    {
        Book existingBook=bookRepository.findById(id).orElseThrow();
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthorName(book.getAuthorName());
        bookRepository.save(existingBook);
        return existingBook;
    }
    @Override
    public void deleteBook(int id)
    {
        bookRepository.findById(id).orElseThrow();
        bookRepository.deleteById(id);
    }
}
