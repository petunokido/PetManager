package com.pet.manager.service;

import com.pet.manager.model.Book;
import com.pet.manager.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String authorId, String title) {
        final Book book = Book.builder().title(title).authorId(authorId).build();
        return bookRepository.insert(book);
    }
}
