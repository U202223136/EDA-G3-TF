package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mov {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mov;

    @Column(name = "tip_mov", nullable = false, length = 1)
    private String tipo;

    @Column(nullable = false)
    private Integer id_emp;

    @Column(nullable = false)
    private Integer id_alm;

    @Column(nullable = false)
    private Date fch_mov;

    @Column(nullable = false)
    private Integer id_num;

    @Column(nullable = false, length = 8)
    private String nro_mov;

    @OneToMany(mappedBy = "mov", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovDet> detList;
}
