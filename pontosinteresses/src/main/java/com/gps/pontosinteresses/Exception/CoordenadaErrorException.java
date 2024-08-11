package com.gps.pontosinteresses.Exception;

public class CoordenadaErrorException extends RuntimeException{

    public CoordenadaErrorException() {
        super("Coordenada não pode ser um valor negativo");
    }
}
