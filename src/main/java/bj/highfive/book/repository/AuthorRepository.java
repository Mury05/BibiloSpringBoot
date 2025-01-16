package bj.highfive.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfive.book.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
