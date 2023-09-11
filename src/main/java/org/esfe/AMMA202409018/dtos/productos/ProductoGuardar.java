package org.esfe.AMMA202409018.dtos.productos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductoGuardar implements Serializable {
    private String nombreAMMA;
    private String descripcionAMMA;
    private BigDecimal precio;
}
