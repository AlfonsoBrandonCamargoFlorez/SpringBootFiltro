package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.DetallesVentas;

public interface IDetallesVentas {

    // para encontrar//
    Optional<DetallesVentas> findById(Long id);

    // para guardar//
    DetallesVentas save(DetallesVentas detallesventas);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<DetallesVentas> findAll();

    // para actualizar//
    DetallesVentas update(Long id, DetallesVentas detallesventas);

}
