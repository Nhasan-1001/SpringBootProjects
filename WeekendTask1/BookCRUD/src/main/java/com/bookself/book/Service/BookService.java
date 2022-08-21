package com.bookself.book.Service;

import com.bookself.book.Models.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book>getAllBooks();
    Book getBookById(int id);
    Book updateBook(Book book,int id);
    void deleteBook(int id);
}
