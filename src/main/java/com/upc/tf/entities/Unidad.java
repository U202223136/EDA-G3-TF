package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_und;

    @Column(name = "cod_und", nullable = false, length = 3)
    private String codigo;

    @Column(name = "abr_und", nullable = false, length = 10)
    private String simbolo;

    @Column(name = "dsc_und", nullable = false, length = 50)
    private String descripcion;

    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productoList;

}
