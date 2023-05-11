package com.example.scl2.repository;

import com.example.scl2.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    public Livro getByGenero(String genero);
}
