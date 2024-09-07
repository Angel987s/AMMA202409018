package org.esfe.AMMA202409018.servicios.implementaciones;

import org.esfe.AMMA202409018.dtos.productos.ProductoGuardar;
import org.esfe.AMMA202409018.dtos.productos.ProductoModificar;
import org.esfe.AMMA202409018.dtos.productos.ProductoSalida;
import org.esfe.AMMA202409018.modelos.ProductAMMA;
import org.esfe.AMMA202409018.repositorios.IProductoRepository;
import org.esfe.AMMA202409018.servicios.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoSalida> obtenerTodos() {
        List<ProductAMMA> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<ProductAMMA> page = productoRepository.findAll(pageable);

        List<ProductoSalida> productosDto = page.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProductoSalida obtenerPorId(Integer id) {
        return modelMapper.map(productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")), ProductoSalida.class);
    }

    @Override
    public ProductoSalida crear(ProductoGuardar productoGuardar) {
        ProductAMMA producto = productoRepository.save(modelMapper.map(productoGuardar, ProductAMMA.class));
        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public ProductoSalida editar(ProductoModificar productoModificar) {
        ProductAMMA producto = productoRepository.save(modelMapper.map(productoModificar, ProductAMMA.class));
        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}
