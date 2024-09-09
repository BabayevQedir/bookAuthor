package az.author.book.service;

import az.author.book.dao.model.dto.AuthorDto;
import az.author.book.dao.model.dto.BookDto;

public interface AuthorService {
    void addAuthor(AuthorDto authorDto);
    AuthorDto findAuthor(Long id);

    void deleteAuthor(Long id);
    AuthorDto updateBook(Long id,AuthorDto authorDto);
}
