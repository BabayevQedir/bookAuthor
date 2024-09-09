package az.author.book.exception.handler;

import az.author.book.dao.model.dto.ErrorDto;
import az.author.book.exception.AuthorNotFoundException;
import az.author.book.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto<AuthorNotFoundException>>
    handleCategoryNotFoundException(AuthorNotFoundException categoryNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto<>(404
                        ,categoryNotFoundException.getMessage()
                        ,AuthorNotFoundException.class));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto<BookNotFoundException>>
    handleProductNotFoundException(BookNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto<>(404
                ,ex.getMessage()
                ,BookNotFoundException.class));
    }
}
