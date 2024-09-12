package br.com.mattec.jesse.mongodb.springblog.repositories;

import br.com.mattec.jesse.mongodb.springblog.model.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends MongoRepository<Autor,String> {

}
