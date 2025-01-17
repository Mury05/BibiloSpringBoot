package bj.highfive.book.mapper;

import bj.highfive.book.model.Author;
import bj.highfive.book.dtos.AuthorDTO;

public class AuthorMapper {
    public static AuthorDTO toDTO(Author author){ 
        return new AuthorDTO(author.getId(), author.getNom(), author.getPrenom());
    }
}
