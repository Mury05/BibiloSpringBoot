package bj.highfive.book.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfive.book.Service.AuthorService;
import bj.highfive.book.Service.BookService;
import bj.highfive.book.dtos.AuthorDTO;
import bj.highfive.book.dtos.CreateAuthorDTO;
import bj.highfive.book.mapper.AuthorMapper;
import bj.highfive.book.model.Author;
import bj.highfive.book.model.Book;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors= authorService.getAllAuthors();
        List<AuthorDTO> authorsDTO = new ArrayList<>();

        for(Author author : authors){
            AuthorDTO authorDTO = AuthorMapper.toDTO(author);
            authorsDTO.add(authorDTO);
        }

        return authorsDTO;
    }

    @PostMapping("")
    public ResponseEntity<String> addAuthor(@Valid @RequestBody CreateAuthorDTO createAuthorDTO) {
        try {
            Author author = new Author();
            author.setNom(createAuthorDTO.getNom());
            author.setPrenom(createAuthorDTO.getPrenom());
            author.setNationalite(createAuthorDTO.getNationalite());
            authorService.newAuthor(author);
            Set<Book> books = new HashSet<>();

            for(Long id : createAuthorDTO.getLivreID()){
                books.add(bookService.getBook(id));
            }
            author.setBooks(books);
            return new ResponseEntity<>("Auteur enregistré avec succès !", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable("id") Long authorId) {
        return  AuthorMapper.toDTO(authorService.getAuthor(authorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") Long authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>("L'auteur avec l'id " + authorId + " supprimé avec succès !",
                HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable("id") Long authorId, @RequestBody Author updatedAuthor) {
        Author updated = authorService.updateAuthor(authorId, updatedAuthor);
        if (updated != null) {
            return new ResponseEntity<>("Auteur mis à jour avec succès !", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Auteur introuvable avec l'id " + authorId, HttpStatus.BAD_REQUEST);
    }

}
