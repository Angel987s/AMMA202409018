package org.esfe.AMMA202409018.dtos.productos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductoSalida implements Serializable {
    private Integer id;
    private String nombreMABT;
    private String descripcionMABT;
    private BigDecimal precio;
}
