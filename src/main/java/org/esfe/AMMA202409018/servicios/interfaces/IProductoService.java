package org.esfe.AMMA202409018.servicios.interfaces;

import org.esfe.AMMA202409018.dtos.productos.ProductoGuardar;
import org.esfe.AMMA202409018.dtos.productos.ProductoModificar;
import org.esfe.AMMA202409018.dtos.productos.ProductoSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService {
    List<ProductoSalida> obtenerTodos();

    Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable);

    ProductoSalida obtenerPorId(Integer id);

    ProductoSalida crear(ProductoGuardar productoGuardar);

    ProductoSalida editar(ProductoModificar productoModificar);

    void eliminarPorId(Integer id);
}
