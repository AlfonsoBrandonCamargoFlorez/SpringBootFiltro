package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.Clientes;

public interface IClientes {

    // para encontrar//
    Optional<Clientes> findById(Long id);

    // para guardar//
    Clientes save(Clientes clientes);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<Clientes> findAll();

    // para actualizar//
    Clientes update(Long id, Clientes clientes);

}
