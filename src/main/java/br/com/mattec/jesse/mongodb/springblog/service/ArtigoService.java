package br.com.mattec.jesse.mongodb.springblog.service;

import br.com.mattec.jesse.mongodb.springblog.dto.ArtigoDTO;
import br.com.mattec.jesse.mongodb.springblog.model.Artigo;

import java.time.LocalDateTime;
import java.util.List;

public interface ArtigoService {
    public List<Artigo> obterTdos();
    public Artigo obterPorCodigo(String codigo);
    public Artigo criar(Artigo artigo);
    public List<Artigo> findByGreaterThan(LocalDateTime data);
    public List<Artigo> findByDataAndStatus(LocalDateTime localDateTime, Integer status);
    public void aualizar(ArtigoDTO artigoDto);
}
