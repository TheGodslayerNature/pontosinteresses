package com.gps.pontosinteresses.service;

import com.gps.pontosinteresses.model.PontoDeInteresse;
import com.gps.pontosinteresses.repository.PontoDeInteresseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoDeInteresseService {
    private final PontoDeInteresseRepository repository;

    public PontoDeInteresseService(PontoDeInteresseRepository repository) {
        this.repository = repository;
    }

    public PontoDeInteresse salvarPontoDeInteresse(PontoDeInteresse pontoDeInteresse){
        return repository.save(pontoDeInteresse);
    }

    public PontoDeInteresse getPontoDeInteressse(String id){
        Optional<PontoDeInteresse> pontoDeInteresseOpt = repository.findById(id);
        if (pontoDeInteresseOpt.isPresent()){
            return pontoDeInteresseOpt.get();
        }
        else {
            throw new RuntimeException("Esse ponto de interesse não existe");
        }
    }

    public List<PontoDeInteresse> listarTodos(){
        return repository.findAll();
    }

    public PontoDeInteresse atualizarPontoDeInteresse(PontoDeInteresse novoPontoDeInteresse){
        PontoDeInteresse pontoDeInteresse = getPontoDeInteressse(novoPontoDeInteresse.getId());
        pontoDeInteresse.setNome(novoPontoDeInteresse.getNome());
        pontoDeInteresse.setCoordenadaX(novoPontoDeInteresse.getCoordenadaX());
        pontoDeInteresse.setCoordenadaY(novoPontoDeInteresse.getCoordenadaY());

        return pontoDeInteresse;
    }

    public void deletarPontoDeInteresse(String id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Esse ponto de interesse não existe");
        }
    }
}
