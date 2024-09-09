package az.author.book.rest;

import az.author.book.dao.model.dto.AuthorDto;
import az.author.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public void addAuthor(@RequestBody AuthorDto authorDto){
        authorService.addAuthor(authorDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> findAuthor(@PathVariable Long id){
        return ResponseEntity.ok(authorService.findAuthor(id));
    }

    @DeleteMapping
    public void deleteAuthor(@RequestParam("id") Long id){
        authorService.deleteAuthor(id);
    }

    @PutMapping
    public ResponseEntity<AuthorDto> updateBook(@Param("id") Long id, @RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorService.updateBook(id,authorDto));
    }
}
