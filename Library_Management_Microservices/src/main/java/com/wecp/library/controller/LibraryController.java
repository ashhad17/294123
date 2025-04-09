package com.wecp.library.controller;

import com.wecp.library.domain.Book;
import com.wecp.library.domain.User;
import com.wecp.library.repository.BookRepository;
import com.wecp.library.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller for managing library system process
 */
@RestController
@RequestMapping("/api/v1")
public class LibraryController {




    /**
     * {@code GET  /user/:id} : get the "id" User.
     *
     * @param id the id of the user to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the user, or if does not exist, return with status "noContent".
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok().body(user.get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * {@code POST  /user} : Create a new user.
     *
     * @param user the user to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the new user
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    /**
     * {@code GET  /book/:id} : get the "id" Book.
     *
     * @param id the id of the book to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     * the book, or if does not exist, return with status "noContent".
     */
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()){
            return ResponseEntity.ok().body(book.get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * {@code POST  /book} : Create a new book.
     *
     * @param book the book to create.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the new book
     */
    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookRepository.save(book));
    }
}
