package br.com.mattec.jesse.mongodb.springblog.service.impl;

import br.com.mattec.jesse.mongodb.springblog.model.Autor;
import br.com.mattec.jesse.mongodb.springblog.repositories.AutorRepository;
import br.com.mattec.jesse.mongodb.springblog.service.AutorService;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }


    @Override
    public Autor obterPorCodigo(String codigo) {
        return this.autorRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Autor não existe dentro da collection!"));
    }

    @Override
    public Autor criar(Autor autor) {
        return this.autorRepository.save(autor);
    }
}
