package com.charlies.beach.domain.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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

public class DetallesPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded 
    Audit audit = new Audit();

    @Column(columnDefinition = "Int", nullable = false)
    private int cantidad;

    @Column(columnDefinition = "LONG", nullable = false)
    private Long preciounitario;

    @ManyToOne
    private Pedidos pedidos;

    @ManyToOne
    private Menus menus;

    

    


}
