package com.example.book_service.service;

import com.example.book_service.exceptions.BookNotFoundException;
import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll() ;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book getById(long id){
        Optional<Book> existingBook=bookRepository.findById(id);
        if(existingBook.isPresent())
            return existingBook.get();
        throw new BookNotFoundException("Book not found with id:"+id);
    }

    public void deleteBook(long id){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent())
            bookRepository.deleteById(id);
        throw new BookNotFoundException("Book not found with id:"+id);
    }

    public Book updateBook(long id, Book updateBook){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            Book existingBook = book.get();
            existingBook.setTitle(updateBook.getTitle());
            existingBook.setAuthor(updateBook.getAuthor());
            existingBook.setPrice(updateBook.getPrice());
            existingBook.setStock(updateBook.getStock());

            return bookRepository.save(existingBook);
        }
        else{
            throw new EntityNotFoundException("Book with this id" + id+ "is not present");
        }
    }




}
