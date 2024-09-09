package az.author.book.dao.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    @NotBlank
    @Size(min = 3, max = 20)
    String name;
    @NotBlank
    @Size(min = 3, max = 20)
    Integer bookCount;
}
