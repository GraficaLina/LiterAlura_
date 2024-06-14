package com.alura.Literature.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Autor> autors;
    private String languages;
    private Double numberOfDownloads;


    public Libro() {
    }

    public Libro(DatosLibro datosLibro, List<Autor> autors) {
        this.title = datosLibro.title();
        this.autors = autors;
        this.languages = getFirstLanguage(datosLibro);
        this.numberOfDownloads = datosLibro.numberOfDownloads();

    }
//    public String getFirstLanguage() {
//        return languages != null && !languages.isEmpty() ? languages.get(0) : null;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAuthors() {
        return autors;
    }

    public void setAuthors(List<Autor> autors) {
        this.autors = autors;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Double getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(Double numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }
    public String getFirstLanguage(DatosLibro datosLibro){
        String idioma = datosLibro.languages().toString();
        return idioma;
    }



    @Override
    public String toString() {
        String authorsNames = autors.stream()
                .map(Autor::obtenerNombreCompleto)
                .collect(Collectors.joining(", "));
        return "---- Libro ---- \n" +
                "Titulo= " + title + "\n" +
                "Autor/es= " + authorsNames + "\n" +
                "Lenguaje= " + languages + "\n" +
                "Numero de descargas= " + numberOfDownloads + "\n" +
                "----------------------- \n";


    }
}