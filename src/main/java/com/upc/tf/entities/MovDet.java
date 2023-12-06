package com.upc.tf.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mov_det")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_det;

//    @Column(insertable = false, updatable = false)
//    private Integer id_mov;

    //    @Column(insertable = false, updatable = false)
//    private Integer id_prd;

    @ManyToOne
    @JoinColumn(name = "id_mov", nullable = false)
    private Mov mov;

    @ManyToOne
    @JoinColumn(name = "id_prd", nullable = false)
    private Producto producto;

    @Column(name = "det_cant", nullable = false)
    private Double cantidad;

    @Column(name = "det_pre", nullable = false)
    private Double precio;

}
