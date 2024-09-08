package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.DetallesPedidos;

public interface IDestallesPedidos {

        // para encontrar//
    Optional<DetallesPedidos> findById(Long id);

    // para guardar//
    DetallesPedidos save(DetallesPedidos detallesPedidos);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<DetallesPedidos> findAll();

    // para actualizar//
    DetallesPedidos update(Long id, DetallesPedidos detallesPedidos);

}
