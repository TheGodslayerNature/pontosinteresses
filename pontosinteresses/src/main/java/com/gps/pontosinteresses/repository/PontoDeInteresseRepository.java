package com.gps.pontosinteresses.repository;

import com.gps.pontosinteresses.model.PontoDeInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoDeInteresseRepository extends JpaRepository<PontoDeInteresse,String> {
}
