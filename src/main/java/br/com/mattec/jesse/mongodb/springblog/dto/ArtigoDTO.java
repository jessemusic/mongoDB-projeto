package br.com.mattec.jesse.mongodb.springblog.dto;

import br.com.mattec.jesse.mongodb.springblog.model.Autor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArtigoDTO {

    private String codigo;
    private String titulo;
    private LocalDateTime data;
    private String texto;
    private String url;
    private Integer status;
    private Autor autor;
}
