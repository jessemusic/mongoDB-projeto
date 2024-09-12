package br.com.mattec.jesse.mongodb.springblog.service.impl;

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

}
