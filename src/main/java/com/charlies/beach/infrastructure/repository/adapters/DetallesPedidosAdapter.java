package com.charlies.beach.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IDestallesPedidos;
import com.charlies.beach.domain.entities.DetallesPedidos;
import com.charlies.beach.infrastructure.repository.repository.DetallesPedidoRepository;

@Service
public class DetallesPedidosAdapter implements IDestallesPedidos{
  @Autowired
    private DetallesPedidoRepository DetallesPedidoRepository;
    @Override
    public Optional<DetallesPedidos> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public DetallesPedidos save(DetallesPedidos detallesPedidos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<DetallesPedidos> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public DetallesPedidos update(Long id, DetallesPedidos detallesPedidos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
  
    

    


}
