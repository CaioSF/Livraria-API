package com.example.scl2.repository;

import com.example.scl2.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    @Query("SELECT l FROM Livro l WHERE l.genero = :genero")
    List<Livro> buscarLivrosPorGenero(@Param("genero") String genero);


    boolean existsByIsbn(String isbn);







}

