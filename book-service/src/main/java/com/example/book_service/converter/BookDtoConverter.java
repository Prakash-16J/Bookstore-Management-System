package com.example.book_service.converter;

import com.example.book_service.dto.BookDto;
import com.example.book_service.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    public BookDto convertToDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStock()
        );
    }

    public Book convertToEntity(BookDto bookdto){
        return new Book(
                bookdto.id(),
                bookdto.tile(),
                bookdto.author(),
                bookdto.price(),
                bookdto.stock()
        );
    }
}
