package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_kar;

    @Column(nullable = false)
    private Date fch_kar;

    @Column(insertable = false, updatable = false)
    private Integer id_prd;

    @Column(name = "ini_kar", nullable = false)
    private double inicial;

    @Column(name = "ing_kar", nullable = false)
    private double ingreso;

    @Column(name = "egr_kar", nullable = false)
    private double salida;

    @Column(name = "sal_kar", nullable = false)
    private double stock;

    private Integer ref_id_mov;

    private Integer ref_id_ven;

    @Column(name = "cos_kar", nullable = false)
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "id_prd", nullable = false)
    private Producto producto;

}
