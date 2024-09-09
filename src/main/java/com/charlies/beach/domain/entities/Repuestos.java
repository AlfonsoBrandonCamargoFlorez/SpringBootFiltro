package com.charlies.beach.domain.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Repuestos {
   @Id
    // genero el id de la tabla y que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "LONG", nullable = false)
    private Long precio;

    @Column(columnDefinition = "INT", nullable = false)
    private int stock;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Modelo modelo;

    @ManyToOne
    private Proveedores proveedores;

    // @OneToMany(mappedBy = "proveedores", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    // private Set<DetallesCompras> detallesCompras;

}
