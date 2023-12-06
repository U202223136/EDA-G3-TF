package com.upc.tf.entities;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Numerador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_num;

//    @Column( name = "id_doc") //, nullable = false, insertable = false, updatable = false
//    private Integer tipo;

    @Column(name = "ser_num", nullable = false, length = 4)
    private String serie;

    @Column(name = "nro_num", nullable = false)
    private Integer nro;

    @ManyToOne
    @JoinColumn(name = "id_doc", nullable = false)
    private Documento documento;

    @Override
    public String toString() {
        return "\n{" +
                "tipo='" + documento.getCodigo() + "'" +
                ", serie='" + serie + "'" +
                '}';
    }
}
