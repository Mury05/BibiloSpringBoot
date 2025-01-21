package bj.highfive.book.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfive.book.model.Author;
import bj.highfive.book.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

     public Author newAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        return  authorRepository.findById(id).get();
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

     public Author updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            // Copier les propriétés du livre mis à jour dans le livre existant
            BeanUtils.copyProperties(updatedAuthor, existingAuthor, "id");
            return authorRepository.save(existingAuthor);
        }
        return null;
    }
}
