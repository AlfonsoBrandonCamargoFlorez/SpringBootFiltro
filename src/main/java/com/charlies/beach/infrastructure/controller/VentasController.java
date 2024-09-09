package com.charlies.beach.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charlies.beach.application.service.IVentas;
import com.charlies.beach.domain.entities.Ventas;



@RestController
public class VentasController {

    @Autowired
    private IVentas ventasService;

    @GetMapping
    public ResponseEntity<List<Ventas>> getAllVentas() {
        List<Ventas> ventas = ventasService.findAll();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Ventas> createVentas(@RequestBody Ventas ventas) {
        Ventas createdVentas = ventasService.save(ventas);
        return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);
    }

        @PutMapping("/{id}")
    public ResponseEntity<Ventas> updateVentas(@PathVariable Long id, @RequestBody Ventas ventas) {
        Ventas updatedVentas = ventasService.update(id, ventas);
        return updatedVentas != null ? ResponseEntity.ok(updatedVentas)
                                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentas(@PathVariable Long id) {
        if (ventasService.findById(id).isPresent()) {
            ventasService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}

