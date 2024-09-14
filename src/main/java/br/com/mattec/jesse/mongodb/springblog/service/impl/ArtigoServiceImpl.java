package br.com.mattec.jesse.mongodb.springblog.service.impl;

import br.com.mattec.jesse.mongodb.springblog.dto.ArtigoDTO;
import br.com.mattec.jesse.mongodb.springblog.exceptions.ArtigoNotFoundException;
import br.com.mattec.jesse.mongodb.springblog.model.Artigo;
import br.com.mattec.jesse.mongodb.springblog.model.Autor;
import br.com.mattec.jesse.mongodb.springblog.repositories.ArtigoRepository;
import br.com.mattec.jesse.mongodb.springblog.repositories.AutorRepository;
import br.com.mattec.jesse.mongodb.springblog.service.ArtigoService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArtigoServiceImpl implements ArtigoService {

    private final MongoTemplate mongoTemplate;

    private final ArtigoRepository artigoRepository;
    private final AutorRepository autorRepository;

    public ArtigoServiceImpl(ArtigoRepository artigoRepository, AutorRepository autorRepository, MongoTemplate mongoTemplate){
        this.artigoRepository = artigoRepository;
        this.autorRepository = autorRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Artigo> obterTdos() {
        return this.artigoRepository.findAll();
    }

    @Override
    public Artigo obterPorCodigo(String codigo) {
        return this.artigoRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Artigo não existe dentro da collection!"));
    }

    @Override
    public Artigo criar(Artigo artigo) {
        if(artigo.getAutor().getCodigo() != null){
            Autor autorEncontrado =  this.autorRepository.findById(artigo.getAutor().getCodigo())
                    .orElseThrow(() -> new IllegalArgumentException("Auto não existe"));
            artigo.setAutor(autorEncontrado);
        }else{
            artigo.setAutor(null);
        }
        return this.artigoRepository.save(artigo);
    }

    @Override
    public List<Artigo> findByGreaterThan(LocalDateTime data) {
        Query query = new Query(Criteria.where("data").gt(data));
        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status) {
        Query query = new Query(Criteria.where("data").is(data)
                .and("status").is(status));
        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public void aualizar(ArtigoDTO artigoReq) {
        Optional<Artigo> idArtigo = this.artigoRepository.findById(artigoReq.getCodigo());
        Artigo artigo = idArtigo.orElseThrow(() -> new ArtigoNotFoundException("Artigo não encontrado no banco de dados"));;

            if (artigoReq.getTitulo() != null) {
                artigo.setTitulo(artigoReq.getTitulo());
            }
            if (artigoReq.getData() != null) {
                artigo.setData(artigoReq.getData());
            }
            if (artigoReq.getTexto() != null) {
                artigo.setTexto(artigoReq.getTexto());
            }
            if (artigoReq.getUrl() != null) {
                artigo.setUrl(artigoReq.getUrl());
            }
            if (artigoReq.getStatus() != null) {
                artigo.setStatus(artigoReq.getStatus());
            }
            if (artigoReq.getAutor() != null) {
                artigo.setAutor(artigoReq.getAutor());
            }

        this.artigoRepository.save(artigo);
    }

}
