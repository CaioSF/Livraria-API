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
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/livro")
@CrossOrigin(origins = "http://127.0.0.1:3000")


public class LivroResource {

    @Autowired
    private LivroRepository livroRepository;




    @GetMapping(value = "/list")
    @CrossOrigin(origins = "http://127.0.0.1:3000")

    public List<Livro> list() {
        return livroRepository.findAll();
    }


    @GetMapping("getById/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:3000")

    public Optional<Livro> getById(@PathVariable(value = "id") int id) {
        return livroRepository.findById(id);
    }



    @GetMapping("/livros/{genero}")
    @CrossOrigin(origins = "http://127.0.0.1:3000")

    public List<Livro> getLivrosPorGenero(@PathVariable String genero) {
        return livroRepository.buscarLivrosPorGenero(genero);
    }





    @PostMapping("/create")
    @CrossOrigin(origins = "http://127.0.0.1:3000")


    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        LivroController livroController = new LivroController();

        if (livroRepository.existsByIsbn(livro.getIsbn())) {
            return new ResponseEntity("O livro já existe!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (!livroController.isLivroValido(livro)) {
            return new ResponseEntity("Dados do livro inválidos", HttpStatus.INTERNAL_SERVER_ERROR);

        }



        livro.setDataCadastro(new Date());
        livro = livroRepository.save(livro);
        return new ResponseEntity(livro, HttpStatus.OK);
    }

    @PutMapping("/edit")

    public ResponseEntity<Livro> editar(@RequestBody Livro livro) {
        LivroController livroController = new LivroController();
        if (!livroController.isLivroValido(livro)) {
            return new ResponseEntity("Nome do livro é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        livro = livroRepository.save(livro);
        return new ResponseEntity(livro, HttpStatus.OK);
    }

//    @PutMapping("/edit/{isbn}")
//
//
//    public ResponseEntity<Livro> editar( @PathVariable(value = "isbn") String isbn,@RequestBody Livro livro) {
//        LivroController livroController = new LivroController();
//        if (!livroController.isLivroValido(livro)) {
//            return new ResponseEntity("Nome do livro é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        if (!isbn.equals(livro.getIsbn())) {
//            return new ResponseEntity("O isbn do livro deve ser mantido!", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//
//
//        livro = livroRepository.save(livro);
//        return new ResponseEntity(livro, HttpStatus.OK);
//    }

    @GetMapping("/total")
    @CrossOrigin(origins = "http://127.0.0.1:3000")

    public long getTotal() {
        return livroRepository.count();
    }
    @DeleteMapping("/remove/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:3000")

    public Livro remove(@PathVariable(value = "id") int id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        livroRepository.delete(optionalLivro.get());
        return optionalLivro.get();
    }

}
