package com.charlies.beach.application.service;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.domain.entities.Pedidos;

public interface IPedidos {

        //para encontrar//
        Optional<Pedidos> findById(Long id);

        //para guardar//
        Pedidos save(Pedidos pedidos);
        
        //para eliminar//
        void deleteById(Long id);
    
        //para listar todas//
        List<Pedidos> findAll();
    
        //para actualizar//
        Pedidos update(Long id, Pedidos pedidos);
    

}
