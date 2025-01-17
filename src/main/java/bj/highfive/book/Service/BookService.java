package bj.highfive.book.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfive.book.model.Book;
import bj.highfive.book.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import bj.highfive.book.dtos.BookDTO;
import bj.highfive.book.mapper.BookMapper;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Ajouter
    public Book newBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookDTO getBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = bookOptional.get();
        return BookMapper.toDTO(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            // Copier les propriétés du livre mis à jour dans le livre existant
            BeanUtils.copyProperties(updatedBook, existingBook, "id");
            return bookRepository.save(existingBook);
        }
        return null;
    }
    // public List<Book> searchBooks(Author author, LocalDate year) {
    //     if (year != null) {
    //         return bookRepository.findByAuthorAndYear(author, year);
    //     } else {
    //         return bookRepository.findByAuthor(author);
    //     }
    // }

}
