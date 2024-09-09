package com.charlies.beach.infrastructure.repository.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IVentas;

import com.charlies.beach.domain.entities.Ventas;
import com.charlies.beach.infrastructure.repository.repository.VentasRepository;

@Service
public class VentasAdapter implements IVentas {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public Optional<Ventas> findById(Long id) {
        return ventasRepository.findById(id);
    }

    @Override
    public Ventas save(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public void deleteById(Long id) {
        ventasRepository.deleteById(id);
    }

    @Override
    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas update(Long id, Ventas ventas) {
        return ventasRepository.findById(id)
                .map(existingVentas -> {
                    existingVentas.setFecha(ventas.getFecha());
                    existingVentas.setClientes(ventas.getClientes());
                    

                    return ventasRepository.save(existingVentas);
                })
                .orElse(null);
    }

}
