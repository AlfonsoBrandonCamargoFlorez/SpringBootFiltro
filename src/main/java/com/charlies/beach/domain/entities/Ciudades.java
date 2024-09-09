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

public class Ciudades {
    @Id
    // genero el id de la tabla y que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @ManyToOne
    private Paises paises;

    @OneToMany(mappedBy = "ciudades", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    private Set<Clientes> clientes;

    // @OneToMany(mappedBy = "ciudades", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    // private Set<Proveedores> proveedores;

    

}
