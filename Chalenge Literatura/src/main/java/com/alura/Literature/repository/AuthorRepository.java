package com.alura.Literature.repository;

import com.alura.Literature.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Autor,Long> {
    Optional<Autor> findByFullName(String name);
    @Query("SELECT a FROM Author a WHERE :year >= a.birthDate AND (:year <= a.dateOfDeath OR a.dateOfDeath IS NULL)")
    List<Autor> authorForYear(int year);
}
