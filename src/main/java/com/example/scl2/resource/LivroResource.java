package com.example.scl2.resource;


import com.example.scl2.controller.LivroController;
import com.example.scl2.dominio.Livro;
import com.example.scl2.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/livro")


public class LivroResource {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value = "/list")
    public List<Livro> list() {
        return livroRepository.findAll();
    }

    //@GetMapping(value = "/{genero}")
    //public List<Livro> list() {
       // return livroRepository.getByGenero(String genero);
    //}

    @PostMapping("/create")
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        LivroController livroController = new LivroController();
        if (!livroController.isLivroValido(livro)) {
            return new ResponseEntity("Dados inválidos", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        livro.setDataCadastro(new Date());
        livro = livroRepository.save(livro);
        return new ResponseEntity(livro, HttpStatus.OK);
    }
}
