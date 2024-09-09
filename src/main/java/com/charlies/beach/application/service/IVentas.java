package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.Ventas;

public interface IVentas {

    // para encontrar//
    Optional<Ventas> findById(Long id);

    // para guardar//
    Ventas save(Ventas bicicletas);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<Ventas> findAll();

    // para actualizar//
    Ventas update(Long id, Ventas bicicletas);

}
