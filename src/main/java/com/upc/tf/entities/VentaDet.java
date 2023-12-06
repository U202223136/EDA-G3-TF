package com.upc.tf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Venta_det")
public class VentaDet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vdet;

    @Column(nullable = false, insertable = false, updatable = false)
    private Integer id_ven;

    @Column(nullable = false, insertable = false, updatable = false)
    private Integer id_prd;

    @Column(name = "vdet_cant", nullable = false)
    private Double cantidad;

    @Column(name = "vdet_pre", nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_ven", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_prd", nullable = false)
    private Producto producto;

}
