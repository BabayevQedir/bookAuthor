package az.author.book.rest;

import az.author.book.dao.model.dto.BookDto;
import az.author.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> findBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findBook(id));
    }

    @DeleteMapping
    public void deleteBook(@RequestParam("id") Long id){
        bookService.deleteBook(id);
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@Param("id") Long id,@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.updateBook(id,bookDto));
    }
}
