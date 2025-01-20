package bj.highfive.book.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAuthorDTO {

    @NotNull(message = "Le nom de l'auteur est requis !")
    private String nom;
    // @NotNull(message = "Le prenom de l'auteur est requis !")
    private String prenom;
    @NotNull(message = "La nationalité de l'auteur est requise !")
    private String nationalite;

    public CreateAuthorDTO( String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }
}
