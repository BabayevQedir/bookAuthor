package az.author.book.service;


import az.author.book.dao.model.dto.BookDto;

public interface BookService {
    void addBook(BookDto bookDto);

    BookDto findBook(Long id);

    void deleteBook(Long id);

    BookDto updateBook(Long id, BookDto bookDto);
}
