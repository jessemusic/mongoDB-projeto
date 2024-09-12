package br.com.mattec.jesse.mongodb.springblog.service;

import br.com.mattec.jesse.mongodb.springblog.model.Autor;

public interface AutorService {
    public Autor obterPorCodigo(String codigo);
    public Autor criar(Autor autor);
}
