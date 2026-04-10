package com.example.BookService.service;

import com.example.BookService.dto.BookDTO;
import com.example.BookService.entity.Book;
import com.example.BookService.exception.BookException;
import com.example.BookService.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    //field injection - not recommand
    @Autowired
    BookRepository bookRepository;

    @Autowired
    Environment environment;

    private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public List<BookDTO> getAllBook() throws BookException {
        List<Book> bookList = bookRepository.findAll();

        if(bookList.isEmpty()){
            logger.info("No Book available");
            throw new BookException(environment.getProperty("BOOK_NOT_FOUND"));
        }
        else {
            List<BookDTO> bookDTOList = new ArrayList<>();
            for(Book b:bookList){
                bookDTOList.add(BookDTO.createDTO(b));
            }

            logger.info("All Books details fetched");
            return bookDTOList;
        }
    }

    @Override
    public BookDTO getBookById(Long id) throws BookException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            logger.info("there is no book available for this id {}", id);
            throw new BookException("No book Found for this id {}" + id);
        }
        else {
            logger.info("Book detail fetched successfully for id {}", id);
            return BookDTO.createDTO(optionalBook.get());
        }
    }

    @Override
    public String addBook(BookDTO bookDTO) throws BookException {
        logger.info("addBook method called");
//        if (bookRepository.existsById(bookDTO.getId())) {
//            logger.info("Book is already there");
//            throw new BookException("Book is already there");
//        } else {
            Book book = BookDTO.createEntity(bookDTO);
            bookRepository.save(book);
            logger.info("Book has been added successfully");
            return "Book has been added successfully with id: " + book.getId();

    }

    @Override
    public String modifyBook(long id, BookDTO bookDTO) throws BookException {
        logger.info("modifyBook method called");

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> {
                    logger.info("No book found for id " + id);
                    return new BookException("No Book Found" + id);
                });

        Book newBook = BookDTO.createEntity(bookDTO);
        bookRepository.save(book);

        logger.info("Book has been modified successfully");
        return "Book has been modified successfully";
    }

    @Override
    public String deleteBookById(long id) throws BookException {
        logger.info("deleteBookById method called");

        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) {
            logger.info("There is no book available for this id");
            throw new BookException("No Book Found for id: " + id);
        } else {
            bookRepository.deleteById(id);
            logger.info("Book deleted successfully");
            return "Book has been deleted successfully";
        }
    }
}
