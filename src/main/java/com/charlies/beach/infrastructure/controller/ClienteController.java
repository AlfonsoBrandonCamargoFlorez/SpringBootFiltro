package com.charlies.beach.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlies.beach.application.service.IClientes;
import com.charlies.beach.domain.entities.Clientes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClientes clientesService;

    @GetMapping
    public ResponseEntity<List<Clientes>> getAllClientess() {
        List<Clientes> clientes = clientesService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Clientes> createClientes(@RequestBody Clientes clientes) {
        Clientes createdClientes = clientesService.save(clientes);
        return new ResponseEntity<>(createdClientes, HttpStatus.CREATED);
    }

        @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateClientes(@PathVariable Long id, @RequestBody Clientes clientes) {
        Clientes updatedClientes = clientesService.update(id, clientes);
        return updatedClientes != null ? ResponseEntity.ok(updatedClientes)
                                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientes(@PathVariable Long id) {
        if (clientesService.findById(id).isPresent()) {
            clientesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
