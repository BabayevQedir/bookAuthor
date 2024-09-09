package az.author.book.dao.model.dto;

import az.author.book.dao.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDto {
    @NotBlank
    @Size(min = 3, max = 20)
    String name;
    @NotBlank
    @Size(min = 3, max = 20)
    String surname;

    List<Book> books;
}
