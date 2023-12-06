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
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doc;

    @Column(name = "cod_doc", nullable = false, length = 3)
    private String codigo;

    @Column(name = "dsc_doc", nullable = false, length = 35)
    private String descripcion;

    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Numerador> numeradorList;
}
