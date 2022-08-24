package Entities;

import org.springframework.data.annotation.Id;

import java.time.Instant;

public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;
    private Instant publishedDate;
    private Integer pageCount;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }
}