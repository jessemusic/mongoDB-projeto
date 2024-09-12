package br.com.mattec.jesse.mongodb.springblog.controllers;

import br.com.mattec.jesse.mongodb.springblog.model.Autor;
import br.com.mattec.jesse.mongodb.springblog.service.AutorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @GetMapping("/{codigo}")
    public Autor obterPorCodigo(@PathVariable String codigo){
        return this.autorService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Autor criar(@RequestBody Autor autor){
        return this.autorService.criar(autor);
    }

}
