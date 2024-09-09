package com.charlies.beach.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IDetallesVentas;
import com.charlies.beach.domain.entities.DetallesVentas;
import com.charlies.beach.infrastructure.repository.repository.DetallesVentasRepository;

@Service
public class DetallesVentasAdapter implements IDetallesVentas {
    @Autowired
    private DetallesVentasRepository detallesventasRepository;

    @Override
    public Optional<DetallesVentas> findById(Long id) {
        return detallesventasRepository.findById(id);
    }

    @Override
    public DetallesVentas save(DetallesVentas detallesventas) {
        return detallesventasRepository.save(detallesventas);
    }

    @Override
    public void deleteById(Long id) {
        detallesventasRepository.deleteById(id);
    }

    @Override
    public List<DetallesVentas> findAll() {
        return detallesventasRepository.findAll();
    }

    @Override
    public DetallesVentas update(Long id, DetallesVentas detallesventas) {
        return detallesventasRepository.findById(id)
                .map(existingDetallesVentas -> {
                    existingDetallesVentas.setCantidad(detallesventas.getCantidad());
                    existingDetallesVentas.setPreciounitario(detallesventas.getPreciounitario());
                    existingDetallesVentas.setVentas(detallesventas.getVentas());
                    existingDetallesVentas.setBicicletas(detallesventas.getBicicletas());

                    return detallesventasRepository.save(existingDetallesVentas);
                })
                .orElse(null);
    }

}
