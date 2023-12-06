package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_emp;

    @Column(name = "tip_emp", nullable = false, length = 1)
    private String tipo;

    @Column(name = "cod_emp", nullable = false, length = 12)
    private String codigo;

    @Column(name = "dsc_emp", nullable = false, length = 80)
    private String descripcion;

    @Column(name = "dir_emp", nullable = false, length = 250)
    private String direccion;

    @Override
    public String toString() {
        return "\n{" +
                "codigo='" + codigo + "'" +
                ", descripcion='" + descripcion + "'" +
                '}';
    }
}
