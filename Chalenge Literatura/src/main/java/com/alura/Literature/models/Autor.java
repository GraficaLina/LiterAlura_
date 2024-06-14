package com.alura.Literature.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private int birthDate;
    private int dateOfDeath;

    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros;


    public Autor() {
    }
    public Autor(DatosAutor datosAutor) {
        this.fullName = datosAutor.nameSurname();
        this.birthDate = Integer.valueOf(datosAutor.birthDate()) ;
        this.dateOfDeath = Integer.valueOf(datosAutor.dateOfDeath()) ;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String obtenerNombreCompleto() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(int dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Libro> getBooks() {
        return libros;
    }

    public void setBooks(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        String bookList = libros.stream()
                .map(Libro::getTitle)
                .collect(Collectors.joining(", "));
        return "----- Autor -----\n" +
                "Nombre: " + fullName +"\n"+
                "Año nacimiento: " + birthDate +"\n"+
                "Año fallecimiento: " + dateOfDeath +"\n"+
                "libros: " + bookList;

    }
}
