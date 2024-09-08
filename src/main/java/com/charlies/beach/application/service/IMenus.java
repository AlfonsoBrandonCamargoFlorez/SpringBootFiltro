package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.Menus;

public interface IMenus {

        // para encontrar//
    Optional<Menus> findById(Long id);

    // para guardar//
    Menus save(Menus menus);

    // para eliminar//
    void deleteById(Long id);

    // para listar todas//
    List<Menus> findAll();

    // para actualizar//
    Menus update(Long id, Menus menus);

}
