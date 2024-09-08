package com.charlies.beach.infrastructure.repository.adapters;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlies.beach.application.service.IClientes;
import com.charlies.beach.domain.entities.Audit;
import com.charlies.beach.domain.entities.Clientes;
import com.charlies.beach.infrastructure.repository.repository.ClientesRepository;

@Service
public class ClientesAdapter implements IClientes{
    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public Optional<Clientes> findById(Long id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Clientes save(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    public void deleteById(Long id) {
        clientesRepository.deleteById(id);
    }

    @Override
    public List<Clientes> findAll() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes update(Long id, Clientes clientes) {
        return clientesRepository.findById(id)
        .map(existingClientes -> {
            existingClientes.setNombre(clientes.getNombre());
            existingClientes.setApellido(clientes.getApellido());
            existingClientes.setCorreo(clientes.getCorreo());
            existingClientes.setTelefono(clientes.getTelefono());

            Audit audit = existingClientes.getAudit();
            audit.setUpdatedAt(LocalDateTime.now());
            existingClientes.setAudit(audit);
            
            return clientesRepository.save(existingClientes);
        })
        .orElse(null); 
    }

}   
