package com.gps.pontosinteresses.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pontos")
public class PontosController {

    @PostMapping
    public ResponseEntity salvarPontoDeInteresse(@RequestBody PontoInteresse pontoInteresse){
        return new ResponseEntity<>(pontoInteresse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarUmPontoDeInteresse(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(pontoDeInteresse,HttpStatus.OK);
    }
}
