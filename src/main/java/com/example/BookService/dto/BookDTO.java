package com.example.BookService.dto;

import com.example.BookService.entity.Book;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookDTO  {
    long id;

    @NotNull
    String title;
    String author;
    float price;
    int quantity;
    LocalDate publishedDate;
    String description;

    public BookDTO() {
    }

    public BookDTO(long id, String title, String author, float price, int quantity, LocalDate publishedDate, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.publishedDate = publishedDate;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Book createEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setQuantity(bookDTO.getQuantity());
        book.setPublishedDate(bookDTO.getPublishedDate());
        book.setDescription(bookDTO.getDescription());
        return book;
    }

    public static BookDTO createDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setPublishedDate(book.getPublishedDate());
        bookDTO.setDescription(book.getDescription());
        return bookDTO;
    }
}
