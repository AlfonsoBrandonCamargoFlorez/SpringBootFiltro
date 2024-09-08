package com.charlies.beach.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;

import com.charlies.beach.application.service.IPedidos;
import com.charlies.beach.domain.entities.Pedidos;

public class PedidosAdapter implements IPedidos {

    @Override
    public Optional<Pedidos> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Pedidos save(Pedidos pedidos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Pedidos> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Pedidos update(Long id, Pedidos pedidos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
   

}
