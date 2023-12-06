package com.upc.tf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usu;

    @Column(name = "nom_usu", nullable = false, length = 30)
    private String nombre;

    @Column(name = "clv_usu", nullable = false, length = 30)
    private String clave;

    @Column(name = "adm_usu", nullable = false)
    private boolean admin;

    @Column(nullable = false)
    private boolean activo;

    private static final String ALGORITMO = "AES";
    private static final byte[] claveSecreta = {0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79};

    public void encriptar() throws Exception {
        Key key = new SecretKeySpec(claveSecreta, ALGORITMO);
        Cipher c = Cipher.getInstance(ALGORITMO);
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] encVal = c.doFinal(this.clave.getBytes());
        this.clave = Base64.getEncoder().encodeToString(encVal);
    }

}
