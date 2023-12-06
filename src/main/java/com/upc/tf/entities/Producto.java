package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prd;

    @Column(name = "cod_prd", nullable = false, length = 10)
    private String codigo;

    @Column(name = "dsc_prd", nullable = false, length = 80)
    private String descripcion;

    @Column(name = "min_prd", nullable = false)
    private Double minimo;

    @Column(name = "max_prd", nullable = false)
    private Double maximo;

    @ManyToOne
    @JoinColumn(name = "id_und", nullable = false)
    private Unidad unidad;


    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovDet> movDetList;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Kardex> kardexList;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaDet> ventaDetList;

    @Override
    public String toString() {
        return "\n{" +
                "id_prd=" + id_prd +
                ", codigo='" + codigo + "'" +
                ", descripcion='" + descripcion + "'" +
                ", unidad='" + unidad.getSimbolo() +"'" +
                ", minimo=" + minimo +
                ", maximo=" + maximo +
                '}';
    }
}
