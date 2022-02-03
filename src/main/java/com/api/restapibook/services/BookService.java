package com.api.restapibook.services;

import java.util.List;
import java.util.Optional;

import com.api.restapibook.dao.BookRepository;
import com.api.restapibook.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
   
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();
    
    // static{
    //     list.add(new Book(1, "Head First Java", "Abhishek"));
    //     list.add(new Book(2, "Spring in Java", "Gulmohar"));
    //     list.add(new Book(3, "Think in Java", "Manohar"));
    // }

    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id) {
        Optional<Book> book = this.bookRepository.findById(id);
        // list.stream().filter(e->e.getId() == id).findFirst().get();
        return book.get();
    }

    public Book addBook(Book b){
        // list.add(b);
        this.bookRepository.save(b);
        return b;
    }
    public void deleteBook(int id){
    
        // Book book = list.stream().filter(e->e.getId() == id).findFirst().get();

        // System.out.println(book);
    
        // list.remove(book);
        this.bookRepository.deleteById(id);
    }
    public Book updateBook(int id, Book newBook){
        // delete the old book 
        // Book oldBook = list.stream().filter(e->e.getId() == id).findFirst().get();
        // list.remove(oldBook);
        // // add the updated book
        // list.add(newBook);
        // return newBook;
        newBook.setId(id); // incase if id and book does not match
        return this.bookRepository.save(newBook);
    }
}

