package bj.highfive.book.dtos;

import java.time.LocalDate;

public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private LocalDate published_at;
    public BookDTO(Long id, String title, String isbn, LocalDate published_at) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.published_at = published_at;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public LocalDate getPublished_at() {
        return published_at;
    }
    public void setPublished_at(LocalDate published_at) {
        this.published_at = published_at;
    } 
    
    
}
