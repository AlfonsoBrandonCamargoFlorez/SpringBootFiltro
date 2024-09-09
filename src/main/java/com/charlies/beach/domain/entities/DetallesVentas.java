package com.charlies.beach.domain.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity

public class DetallesVentas {
    @Id
    // genero el id de la tabla y que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT", nullable = false)
    private int cantidad;

    @Column(columnDefinition = "INT", nullable = false)
    private int preciounitario;

    @ManyToOne
    private Ventas ventas;

    @ManyToOne
    private Bicicletas bicicletas;


}
