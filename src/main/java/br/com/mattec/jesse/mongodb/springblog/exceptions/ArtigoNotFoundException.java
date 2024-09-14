package br.com.mattec.jesse.mongodb.springblog.exceptions;

public class ArtigoNotFoundException extends RuntimeException{
    public ArtigoNotFoundException(String message) {
        super(message);
    }
}
