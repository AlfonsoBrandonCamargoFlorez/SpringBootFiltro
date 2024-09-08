package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.Empleados;

public interface IEmpleados {

        // para encontrar//
    Optional<Empleados> findById(Long id);

    // para guardar//
    Empleados save(Empleados empleados);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<Empleados> findAll();

    // para actualizar//
    Empleados update(Long id, Empleados empleados);

}
