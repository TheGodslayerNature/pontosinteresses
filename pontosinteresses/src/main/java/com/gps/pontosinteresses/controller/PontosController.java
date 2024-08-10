package com.gps.pontosinteresses.controller;

import com.gps.pontosinteresses.model.PontoDeInteresse;
import com.gps.pontosinteresses.service.PontoDeInteresseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pontos")
public class PontosController {

    private final PontoDeInteresseService service;

    public PontosController(PontoDeInteresseService pontoDeInteresse) {
        this.service = pontoDeInteresse;
    }

    @PostMapping
    public ResponseEntity salvarPontoDeInteresse(@RequestBody PontoDeInteresse pontoInteresse){
        return new ResponseEntity<>(service.salvarPontoDeInteresse(pontoInteresse), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity listarTodosOsPontosDeInteresse(){
        return new ResponseEntity(service.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarUmPontoDeInteresse(@PathVariable(name = "id") String id){
        return new ResponseEntity<>(service.getPontoDeInteressse(id),HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPontoDeInteresse(@RequestBody @Valid PontoDeInteresse novoPontoDeInteresse){
        return new ResponseEntity(service.atualizarPontoDeInteresse(novoPontoDeInteresse), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deletePontoDeInteresse(@PathVariable(name = "id")String id){
        service.deletarPontoDeInteresse(id);
        return ResponseEntity.noContent().build();
    }
}
