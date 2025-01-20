package bj.highfive.book.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookDTO {
    @NotNull(message="Le titre du livre est requis !")
    @Size(min = 1, max = 10, message = "Titre trop long. Il doit être compris entre 1 et 10 caractères.")
    private String title;
    @NotNull(message="Le code isbn du livre est requis !")
    @Pattern(regexp = "^[0-9]{13}$", message = " Code Isbn non valide. Il ne doit contenir que 13 chiffres.")
    private String isbn;
    @NotNull(message="La date de publication du livre est requise !")
    private LocalDate published_at;
    public CreateBookDTO(String title, String isbn, LocalDate published_at) {
        this.title = title;
        this.isbn = isbn;
        this.published_at = published_at;
    }

}
