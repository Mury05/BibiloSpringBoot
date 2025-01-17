package bj.highfive.book.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfive.book.dtos.AuthorDTO;
import bj.highfive.book.mapper.AuthorMapper;
import bj.highfive.book.model.Author;
import bj.highfive.book.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors(){
        List<Author> authors= authorRepository.findAll();
        List<AuthorDTO> authorsDTO = new ArrayList<>();

        for(Author author : authors){
            AuthorDTO authorDTO = AuthorMapper.toDTO(author);
            authorsDTO.add(authorDTO);
        }

        return authorsDTO;
    }

     public Author newAuthor(Author author) {
        return authorRepository.save(author);
    }

    public AuthorDTO getAuthor(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        Author author= authorOptional.get();
        return  AuthorMapper.toDTO(author);
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
