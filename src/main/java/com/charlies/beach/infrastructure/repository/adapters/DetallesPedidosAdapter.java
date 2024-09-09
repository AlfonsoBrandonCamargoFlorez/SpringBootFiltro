package com.charlies.beach.infrastructure.repository.adapters;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IDetallesPedidos;
import com.charlies.beach.domain.entities.Audit;
import com.charlies.beach.domain.entities.DetallesPedidos;

import com.charlies.beach.infrastructure.repository.repository.DetallesPedidosRepository;

@Service
public class DetallesPedidosAdapter implements IDetallesPedidos{

    
    @Autowired
    private DetallesPedidosRepository detallesPedidosRepository;

    @Override
    public Optional<DetallesPedidos> findById(Long id) {
        return detallesPedidosRepository.findById(id);
    }

    @Override
    public DetallesPedidos save(DetallesPedidos detallesPedidos) {
        return detallesPedidosRepository.save(detallesPedidos);
    }

    @Override
    public void deleteById(Long id) {
        detallesPedidosRepository.deleteById(id);
    }

    @Override
    public List<DetallesPedidos> findAll() {
        return detallesPedidosRepository.findAll();
    }

     @Override
    public DetallesPedidos update(Long id, DetallesPedidos detallesPedidos) {
        return detallesPedidosRepository.findById(id)
        .map(existingDetallesPedidos -> {
            existingDetallesPedidos.setCantidad(detallesPedidos.getCantidad());
            existingDetallesPedidos.setPreciounitario(detallesPedidos.getPreciounitario());
            existingDetallesPedidos.setPedidos(detallesPedidos.getPedidos());
            existingDetallesPedidos.setMenus(detallesPedidos.getMenus());
            

            Audit audit = existingDetallesPedidos.getAudit();
            audit.setUpdatedAt(LocalDateTime.now());
            existingDetallesPedidos.setAudit(audit);
            
            return detallesPedidosRepository.save(existingDetallesPedidos);
        })
        .orElse(null); 
    }
  

    


}
