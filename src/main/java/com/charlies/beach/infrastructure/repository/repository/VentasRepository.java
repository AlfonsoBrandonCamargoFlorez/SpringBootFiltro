package com.charlies.beach.infrastructure.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charlies.beach.domain.entities.Ventas;

public interface VentasRepository extends JpaRepository <Ventas, Long> {

}
