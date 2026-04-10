package com.example.BookService.controller;

import java.util.List;

import com.example.BookService.dto.BookDTO;
import com.example.BookService.exception.BookException;
import com.example.BookService.service.BookServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    Log LOGGER = LogFactory.getLog(BookController.class);

    @GetMapping("/books")
    public ResponseEntity<?> getAllBook() throws BookException {
        LOGGER.info("getAllBook method of controller class");
        try {
            List<BookDTO> booksDTO = bookServiceImpl.getAllBook();
            return new ResponseEntity<List<BookDTO>>(booksDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById (@PathVariable Long id) throws BookException {
        LOGGER.info("getBookById method of controller class");
        try {
            BookDTO bookDTO = bookServiceImpl.getBookById(id);
            return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addbook")
    public ResponseEntity<?> addBook (@Valid @RequestBody BookDTO bookDTO) throws BookException {
        LOGGER.info("addBook method of controller class");
        try {
            String msg = bookServiceImpl.addBook(bookDTO);
            return new ResponseEntity<String>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> modifyBook ( @Valid @PathVariable long id, @RequestBody BookDTO bookDTO) throws
    BookException {
        LOGGER.info("modifyBook method of controller class");
        try {
            String msg = bookServiceImpl.modifyBook(id, bookDTO);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById ( @PathVariable long id) throws BookException {
        LOGGER.info("deleteBookById method of controller class");
        try {
            String msg = bookServiceImpl.deleteBookById(id);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } catch (Exception e) {
            String msg = e.getMessage();
            return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
        }
    }
}