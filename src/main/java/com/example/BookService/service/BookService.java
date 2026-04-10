package com.example.BookService.service;

import com.example.BookService.dto.BookDTO;
import com.example.BookService.exception.BookException;

import java.util.List;

public interface BookService {
    public List<BookDTO> getAllBook() throws BookException;
    public BookDTO getBookById(Long id) throws BookException;
    public String addBook(BookDTO bookDTO) throws BookException;
    public String modifyBook(long id, BookDTO bookDTO) throws BookException;
    public String deleteBookById(long id) throws BookException;
}
