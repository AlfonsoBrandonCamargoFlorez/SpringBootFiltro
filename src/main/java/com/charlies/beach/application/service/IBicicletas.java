package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.Bicicletas;


public interface IBicicletas {

    // para encontrar//
    Optional<Bicicletas> findById(Long id);

    // para guardar//
    Bicicletas save(Bicicletas bicicletas);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<Bicicletas> findAll();

    // para actualizar//
    Bicicletas update(Long id, Bicicletas bicicletas);

}
