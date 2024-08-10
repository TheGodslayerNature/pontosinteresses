package com.gps.pontosinteresses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ponto-interesse")
@NoArgsConstructor
@Getter
@Setter
public class PontoDeInteresse {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private int coordenadaX;
    @Column(nullable = false)
    private int coordenadaY;

    public PontoDeInteresse(String nome, int coordenadaX, int coordenadaY) {
        this.nome = nome;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
}
