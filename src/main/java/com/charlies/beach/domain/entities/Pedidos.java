package com.charlies.beach.domain.entities;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
public class Pedidos {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "DATE", nullable = false)
    private Date fechapedido;

    @Column(columnDefinition = "LONG", nullable = false)
    private Long Precio;

    @ManyToOne
    private Clientes clientes;

    @ManyToOne
    private Empleados empleados;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    private Set<DetallesPedidos> detallesPedidos;

}
