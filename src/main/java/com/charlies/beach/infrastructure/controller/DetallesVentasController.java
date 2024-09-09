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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlies.beach.application.service.IDetallesVentas;
import com.charlies.beach.domain.entities.DetallesVentas;


@RestController
@RequestMapping("/api/detallesventas")
public class DetallesVentasController {

    @Autowired

    private IDetallesVentas detallesventasService;

    @GetMapping
    public ResponseEntity<List<DetallesVentas>> getAllDetallesVentas() {
        List<DetallesVentas> detallesventas = detallesventasService.findAll();
        return new ResponseEntity<>(detallesventas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetallesVentas> createDetallesVentas(@RequestBody DetallesVentas detallesventas) {
        DetallesVentas createdDetallesVentas = detallesventasService.save(detallesventas);
        return new ResponseEntity<>(createdDetallesVentas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesVentas> updateDetallesVentas(@PathVariable Long id,
            @RequestBody DetallesVentas detallesventas) {
        DetallesVentas updatedDetallesVentas = detallesventasService.update(id, detallesventas);
        return updatedDetallesVentas != null ? ResponseEntity.ok(updatedDetallesVentas)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallesVentas(@PathVariable Long id) {
        if (detallesventasService.findById(id).isPresent()) {
            detallesventasService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
