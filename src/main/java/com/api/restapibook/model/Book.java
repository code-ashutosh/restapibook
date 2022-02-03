package com.api.restapibook.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "books")
public class Book {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // Column name will be id
    
    @Column(name = "book_title")
    private String title;// here Column name will be changed to Book_Title if we use Column annotation

    // Nested Object 
    @OneToOne(cascade = CascadeType.ALL)
    private Author author; 

    // Parameterized Constructor
    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    // default Constructor
    public Book() {
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", title=" + title + "]";
    }
    
    
    
}
