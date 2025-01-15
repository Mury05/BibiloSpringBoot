package bj.highfive.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    // private String allBooks = {};
    List<String> allBooks = new ArrayList<>();

    @GetMapping("")
    public String getAllBooks() {
        return "Liste de tous les livres";
    }

    @PostMapping("")
    public String addBook(){
        return "Livre ajouté avec succès !";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") String bookId){
        return "Le livre avec l'id " + bookId + " est : Les Misérables";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") String bookId){
        return "Le livre à supprimer a l'id " + bookId;
    }

    @PutMapping("/{id}")
    public String updateeBook(@PathVariable("id") String bookId){
        return "Le livre à modifier a l'id " + bookId;
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String author, @RequestParam(required = false) Long year){
        return "Recherche des livres de l'author " + author + " de l'année " + year;
    }

}
