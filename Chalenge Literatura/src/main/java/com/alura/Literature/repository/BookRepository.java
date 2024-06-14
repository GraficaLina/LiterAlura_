package com.alura.Literature.repository;

import com.alura.Literature.models.Libro;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Libro, Long> {
    //recuperar los autores junto con los libros en una sola consulta
    @EntityGraph(attributePaths = "authors")
    //todos los libros pero con el entityGraph para que me traiga los autores
    @Query("SELECT b FROM Book b")
    List<Libro> findAllWithAuthors();

    Libro findByTitleIgnoreCase(String title);

    List<Libro> findByLanguagesContains(String language);
}
