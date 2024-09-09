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

//con los dos primeros evito tener que crear aqui los getter y setter
@Getter
@Setter
// convierto esto en una entidad para crear la tabnla de la base de datos
@Entity

// nombre de la tabla en la base de datos, si no se especifica se toma el nombre
// del entity en singular

public class Clientes {
    @Id
    // genero el id de la tabla y que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(columnDefinition = "LONG", nullable = false)
    private long telefono;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @ManyToOne
    private Ciudades ciudades;

    // @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    // private Set<Ventas> ventas;

}
