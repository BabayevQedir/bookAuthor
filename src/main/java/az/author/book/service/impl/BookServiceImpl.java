package az.author.book.service.impl;

import az.author.book.dao.model.Book;
import az.author.book.dao.model.dto.BookDto;
import az.author.book.dao.repository.BookRepository;
import az.author.book.exception.BookNotFoundException;
import az.author.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final ModelMapper modelMapper;
    private  final BookRepository bookRepository;


    @Override
    public void addBook(BookDto bookDto) {
        bookRepository.save(modelMapper.map(bookDto, Book.class));
    }

    @Override
    public BookDto findBook(Long id) {
        var book=bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("id"));
        return modelMapper.map(book, BookDto.class);    }

    @Override
    public void deleteBook(Long id) {
        findBook(id);
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        var existingBook=findBook(id);
        modelMapper.map(bookDto,existingBook);
        addBook(modelMapper.map(existingBook,BookDto.class));
        return modelMapper.map(existingBook,BookDto.class);
    }
}
