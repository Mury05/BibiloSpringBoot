package bj.highfive.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfive.book.Service.AuthorService;
import bj.highfive.book.model.Author;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")    
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("")
    public String addAuthor(@RequestBody Author author) {
         authorService.newAuthor(author);
         return "Auteur ajouté avec succès !";
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthor(id);

    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return "L'auteur avec l'id "+ id +" supprimé avec succès :";
    }
    
}
