package bj.highfive.book.dtos;

import jakarta.validation.constraints.NotNull;


// @Data
public class CreateAuthorDTO {

    @NotNull(message = "Le nom de l'auteur est requis !")
    private String nom;
    // @NotNull(message = "Le prenom de l'auteur est requis !")
    private String prenom;
    @NotNull(message = "La nationalité de l'auteur est requise !")
    private String nationalite;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public CreateAuthorDTO( String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }
}
