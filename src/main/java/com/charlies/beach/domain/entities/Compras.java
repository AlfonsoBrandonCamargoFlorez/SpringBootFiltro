package com.charlies.beach.domain.entities;

import java.sql.Date;

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

public class Compras {
@Id
    // genero el id de la tabla y que se autoincremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    @Column(columnDefinition = "DATE", nullable = false)
    private Date fecha;

    @Column(columnDefinition = "LONG", nullable = false)
    private Long total;

    @ManyToOne
    private Proveedores proveedores;

    //  @OneToMany(mappedBy = "compras", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    // private Set<DetallesCompras> DetallesCompras;


}
