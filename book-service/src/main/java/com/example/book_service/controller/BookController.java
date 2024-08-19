package com.example.book_service.controller;

import com.example.book_service.converter.BookDtoConverter;
import com.example.book_service.dto.BookDto;
import com.example.book_service.model.Book;
import com.example.book_service.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;
    private final BookDtoConverter converter;

    public BookController(BookService bookService, BookDtoConverter converter) {
        this.bookService = bookService;
        this.converter = converter;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable long id){
        return converter.convertToDto(bookService.getById(id));
    }

    @PostMapping("/addBook")
        public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
            return ResponseEntity.ok(bookService.addBook(book));
        }

    @PutMapping("/updateBook/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable long id, @Valid @RequestBody Book updateBook){
            return ResponseEntity.ok(bookService.updateBook(id,updateBook));
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Book> deleteBook(@PathVariable long id){
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
    }

    }


