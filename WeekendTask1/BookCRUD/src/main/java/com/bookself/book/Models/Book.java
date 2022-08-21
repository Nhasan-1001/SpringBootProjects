package com.bookself.book.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bookdetails")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String bookName;
    @Column
    private String authorName;
}
