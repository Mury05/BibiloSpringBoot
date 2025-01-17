package bj.highfive.book.mapper;

import bj.highfive.book.dtos.BookDTO;
import bj.highfive.book.model.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book){
        return new BookDTO(book.getId(), book.getTitle(), book.getIsbn());
    }
}
