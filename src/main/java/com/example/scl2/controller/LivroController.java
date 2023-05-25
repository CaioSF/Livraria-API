package com.example.scl2.controller;

import com.example.scl2.dominio.Livro;
import com.example.scl2.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
public class LivroController {

    private LivroRepository livroRepository;


    public boolean isLivroValido(Livro livro) {
        return isNomeValido(livro) && isIsbnAndCamposValida(livro);
    }


    private boolean isNomeValido(Livro livro) {
        if ((livro.getNome().isEmpty()) || livro.getNome().length() < 2) {
            return false;
        }

        return true;
    }

    public boolean isIsbnAndCamposValida(Livro livro) {
        if (livro.getIsbn().isEmpty()) return false;
        if (livro.getIsbn().length() < 13) return false;
        if (!livro.getIsbn().matches("[0-9]+")) return false;





        return true;
    }



}
