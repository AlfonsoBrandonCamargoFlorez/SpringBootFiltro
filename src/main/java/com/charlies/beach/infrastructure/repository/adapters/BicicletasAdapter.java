package com.charlies.beach.infrastructure.repository.adapters;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IBicicletas;

import com.charlies.beach.domain.entities.Bicicletas;
import com.charlies.beach.infrastructure.repository.repository.BicicletasRepository;

@Service
public class BicicletasAdapter implements IBicicletas{
    @Autowired
    private BicicletasRepository bicicletasRepository;

    @Override
    public Optional<Bicicletas> findById(Long id) {
        return bicicletasRepository.findById(id);
    }

    @Override
    public Bicicletas save(Bicicletas bicicletas) {
        return bicicletasRepository.save(bicicletas);
    }

    @Override
    public void deleteById(Long id) {
        bicicletasRepository.deleteById(id);
    }

    @Override
    public List<Bicicletas> findAll() {
        return bicicletasRepository.findAll();
    }
    

    @Override
    public Bicicletas update(Long id, Bicicletas bicicletas) {
        return bicicletasRepository.findById(id)
        .map(existingBicicletas -> {
            existingBicicletas.setModelo(bicicletas.getModelo());
            existingBicicletas.setMarca(bicicletas.getMarca());
            existingBicicletas.setPrecio(bicicletas.getPrecio());
            existingBicicletas.setStock(bicicletas.getStock());

            

            
            return bicicletasRepository.save(existingBicicletas);
        })
        .orElse(null); 
    }

}   
