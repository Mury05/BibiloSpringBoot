package bj.highfive.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfive.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
