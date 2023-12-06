package com.upc.tf.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ven;

    @Column(nullable = false)
    private Integer id_emp;

    @Column(nullable = false)
    private Date fch_ven;

    @Column(nullable = false)
    private Integer id_num;

    @Column(nullable = false)
    private String nro_ven;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaDet> ventaDetList;

}
