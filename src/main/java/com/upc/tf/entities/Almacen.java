package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alm;

    @Column(name = "cod_alm", nullable = false, length = 4)
    private String codigo;

    @Column(name = "dsc_alm", nullable = false, length = 80)
    private String descripcion;

    @Override
    public String toString() {
        return "\n{" +
                "id_alm=" + id_alm +
                ", codigo='" + codigo + "'" +
                ", descripcion='" + descripcion + "'" +
                "}";
    }
}
