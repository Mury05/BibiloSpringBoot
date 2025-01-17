package bj.highfive.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfive.book.Service.AuthorService;
import bj.highfive.book.model.Author;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("")
    public String addAuthor(@RequestBody Author author){
        authorService.newAuthor(author);
        return "Auteur enregistré avec succès !";
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long authorId){
        return authorService.getAuthor(authorId);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable("id") Long authorId){
        authorService.deleteAuthor(authorId);
        return "L'auteur avec l'id " + authorId + " supprimé avec succès !";
    }

       @PutMapping("/{id}")
public String updateAuthor(@PathVariable("id") Long authorId, @RequestBody Author updatedAuthor) {
    Author updated = authorService.updateAuthor(authorId, updatedAuthor);
    if (updated != null) {
        return "Auteur mis à jour avec succès !";
    }
    return "Auteur introuvable avec l'id " + authorId;
}
}
