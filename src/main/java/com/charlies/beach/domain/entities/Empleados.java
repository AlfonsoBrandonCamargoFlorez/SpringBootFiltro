package com.charlies.beach.domain.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String apellido;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String cargo;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "empleados", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    private Set<Pedidos> pedidos;


}
