package org.esfe.AMMA202409018.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductAMMA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_amma", nullable = false)
    private String nombreMABT;

    @Column(name = "descripcion_amma")
    private String descripcionMABT;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
}
