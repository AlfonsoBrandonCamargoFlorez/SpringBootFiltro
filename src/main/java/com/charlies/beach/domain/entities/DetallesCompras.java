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

public class DetallesCompras {
    @Id
    // genero el id de la tabla y que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    @Column(columnDefinition = "INT", nullable = false)
    private int cantidad;

    @Column(columnDefinition = "LONG", nullable = false)
    private Long preciounitario;

    @ManyToOne
    private Repuestos repuestos;

    @ManyToOne
    private Compras compras;
    


}
