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

import com.charlies.beach.application.service.IBicicletas;
import com.charlies.beach.domain.entities.Bicicletas;

@RestController
@RequestMapping("/api/bicicletas")
public class BicicletasController {

    @Autowired
    private IBicicletas bicicletasService;

    @GetMapping
    public ResponseEntity<List<Bicicletas>> getAllBicicletas() {
        List<Bicicletas> bicicletas = bicicletasService.findAll();
        return new ResponseEntity<>(bicicletas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bicicletas> createBicicletas(@RequestBody Bicicletas bicicletas) {
        Bicicletas createdBicicletas = bicicletasService.save(bicicletas);
        return new ResponseEntity<>(createdBicicletas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicletas> updateBicicletas(@PathVariable Long id, @RequestBody Bicicletas bicicletas) {
        Bicicletas updatedBicicletas = bicicletasService.update(id, bicicletas);
        return updatedBicicletas != null ? ResponseEntity.ok(updatedBicicletas)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBicicletas(@PathVariable Long id) {
        if (bicicletasService.findById(id).isPresent()) {
            bicicletasService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
