package com.example.scl2.controller;

import com.example.scl2.dominio.Livro;

public class LivroController {

    public boolean isLivroValido(Livro livro) {
        return isNomeValido(livro) && isIsbnValida(livro);
    }

    private boolean isNomeValido(Livro livro) {
        if ((livro.getNome().isEmpty()) || livro.getNome().length() <2) {
            return false;
        }
        return true;
    }

    public boolean isIsbnValida(Livro livro) {
        if(livro.getIsbn().isEmpty()) return false;
        if(livro.getIsbn().length() < 13) return false;
        if(!livro.getIsbn().matches("[0-9]+")) return false;

        return true;
    }
}
