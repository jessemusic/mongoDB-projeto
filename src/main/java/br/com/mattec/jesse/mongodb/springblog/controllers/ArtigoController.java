package br.com.mattec.jesse.mongodb.springblog.controllers;

import br.com.mattec.jesse.mongodb.springblog.dto.ArtigoDTO;
import br.com.mattec.jesse.mongodb.springblog.model.Artigo;
import br.com.mattec.jesse.mongodb.springblog.service.ArtigoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "artigos")
public class ArtigoController {

    private final ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService){
        this.artigoService = artigoService;
    }

    @GetMapping
    public List<Artigo> obterTodos(){
        return this.artigoService.obterTdos();
    }

    @GetMapping("/{codigo}")
    public Artigo obterPorCodigo(@PathVariable String codigo){
        return this.artigoService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Artigo criar(@RequestBody Artigo artigo){
        return this.artigoService.criar(artigo);
    }

    @GetMapping("/maiordata")
    public List<Artigo> findByDataGreaterThan(@RequestParam("data") LocalDateTime data){
        return this.artigoService.findByGreaterThan(data);
    }

    @GetMapping("/data_status")
    public List<Artigo> findByDataAndStatus(
            @RequestParam("data") LocalDateTime data,
            @RequestParam("status") Integer status){
        return this.artigoService.findByDataAndStatus(data,status);
    }

    @PatchMapping
    public void atualiza(@RequestBody ArtigoDTO artigo){
        this.artigoService.aualizar(artigo);
    }


}
