package bj.highfive.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bj.highfive.book.Service.BookService;
import bj.highfive.book.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    // private String allBooks = {};
    List<String> allBooks = new ArrayList<>();

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book){
        bookService.newBook(book);
        return "Livre enregistré avec succès !";
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long bookId){
        
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") Long bookId){
        bookService.deleteBook(bookId);
        return "Le livre avec l'id " + bookId + " supprimé avec succès !";
    }

    // @PutMapping("/{id}")
    // public String updateBook(@PathVariable("id") String bookId){
    //     return "Le livre à modifier a l'id " + bookId;
    // }

    @PutMapping("/{id}")
public String updateBook(@PathVariable("id") Long bookId, @RequestBody Book updatedBook) {
    Book updated = bookService.updateBook(bookId, updatedBook);
    if (updated != null) {
        return "Livre mis à jour avec succès !";
    }
    return "Livre introuvable avec l'id " + bookId;
}


    @GetMapping("/search")
    public String searchBooks(@RequestParam String author, @RequestParam(required = false) Long year){
        return "Recherche des livres de l'author " + author + " de l'année " + year;
    }
//     @GetMapping("/search")
// public List<Book> searchBooks(@RequestParam String author, @RequestParam(required = false) Long year) {
//     return bookService.searchBooks(author, year);
// }


}
