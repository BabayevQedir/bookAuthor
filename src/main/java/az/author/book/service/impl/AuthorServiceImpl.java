package az.author.book.service.impl;

import az.author.book.dao.model.Author;
import az.author.book.dao.model.dto.AuthorDto;
import az.author.book.dao.repository.AuthorRepository;
import az.author.book.exception.AuthorNotFoundException;
import az.author.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;
    @Override
    public void addAuthor(AuthorDto authorDto) {
        authorRepository.save(modelMapper.map(authorDto, Author.class));
    }

    @Override
    public AuthorDto findAuthor(Long id) {
        var author=authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("id"));
        return modelMapper.map(author,AuthorDto.class);
    }

    @Override
    public void deleteAuthor(Long id) {
        findAuthor(id);
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto updateBook(Long id, AuthorDto authorDto) {
        var existingAuthor=findAuthor(id);
        modelMapper.map(authorDto,existingAuthor);
        addAuthor(modelMapper.map(existingAuthor,AuthorDto.class));
        return modelMapper.map(existingAuthor,AuthorDto.class);
    }
}
