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

import com.charlies.beach.application.service.IDetallesPedidos;
import com.charlies.beach.domain.entities.DetallesPedidos;

@RestController
@RequestMapping("/api/detallespedidos")
    
public class DetallesPedidosController {

        @Autowired
    private IDetallesPedidos detallesPedidosService;

    @GetMapping
    public ResponseEntity<List<DetallesPedidos>> getAllDetallesPedidoss() {
        List<DetallesPedidos> detallesPedidos = detallesPedidosService.findAll();
        return new ResponseEntity<>(detallesPedidos, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<DetallesPedidos> createDetallesPedidos(@RequestBody DetallesPedidos detallesPedidos) {
        DetallesPedidos createdDetallesPedidos = detallesPedidosService.save(detallesPedidos);
        return new ResponseEntity<>(createdDetallesPedidos, HttpStatus.CREATED);
    }

        @PutMapping("/{id}")
    public ResponseEntity<DetallesPedidos> updateDetallesPedidos(@PathVariable Long id, @RequestBody DetallesPedidos detallesPedidos) {
        DetallesPedidos updatedDetallesPedidos = detallesPedidosService.update(id, detallesPedidos);
        return updatedDetallesPedidos != null ? ResponseEntity.ok(updatedDetallesPedidos)
                                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallesPedidos(@PathVariable Long id) {
        if (detallesPedidosService.findById(id).isPresent()) {
            detallesPedidosService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
