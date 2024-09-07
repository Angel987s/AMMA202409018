package org.esfe.AMMA202409018.controladores;

import org.esfe.AMMA202409018.dtos.productos.ProductoGuardar;
import org.esfe.AMMA202409018.dtos.productos.ProductoModificar;
import org.esfe.AMMA202409018.dtos.productos.ProductoSalida;
import org.esfe.AMMA202409018.servicios.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<Page<ProductoSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<ProductoSalida> productos = productoService.obtenerTodosPaginados(pageable);
        if(productos.hasContent()){
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductoSalida>> mostrarTodos(){
        List<ProductoSalida> productos = productoService.obtenerTodos();
        if(!productos.isEmpty()){
            return ResponseEntity.ok(productos);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoSalida> buscarPorId(@PathVariable Integer id){
        ProductoSalida producto = productoService.obtenerPorId(id);

        if(producto != null){
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductoSalida> crear(@RequestBody ProductoGuardar productoGuardar){
        ProductoSalida producto = productoService.crear(productoGuardar);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoSalida> editar(@PathVariable Integer id, @RequestBody ProductoModificar productoModificar){
        ProductoSalida producto = productoService.editar(productoModificar);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        productoService.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
