package com.example.BackendProyIntegrador.service.impl;


import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.entity.Producto;
import com.example.BackendProyIntegrador.repository.IProductoRepository;
import com.example.BackendProyIntegrador.service.IProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {


    @Autowired
    IProductoRepository iProductoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardar(ProductoDTO producto) {
        Producto productoNuevo = mapper.convertValue(producto, Producto.class);
        iProductoRepository.save(productoNuevo);


    }

    @Override
    public List<ProductoDTO> listarTodos() {
        List<ProductoDTO> listar = new ArrayList<>();
        for (Producto p: iProductoRepository.findAll()) {
            listar.add(mapper.convertValue(p, ProductoDTO.class));
        }

        return listar;
    }

    @Override
    public ProductoDTO listarId(Long id) throws Exception {
        Optional<Producto> found = iProductoRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, ProductoDTO.class);
        else
            throw new Exception("El producto no existe");
    }

    @Override
    public void eliminar(Long id)  {
        iProductoRepository.deleteById(id);
    }

    @Override
    public void actualizar(ProductoDTO producto) {
        guardar(producto);
    }

    @Override
    public ProductoDTO buscarProductoPorId(Long id) {
        return iProductoRepository.buscarProductoPorId(id);
    }

    @Override
    public List<ProductoDTO> buscarPorFechasDisponibles(LocalDate fechaInicioReserva, LocalDate fechafinReserva) {
        return iProductoRepository.buscarPorFechasDisponibles(fechaInicioReserva,fechafinReserva);
    }

    @Override
    public ProductoDTO buscarPorFechasDisponiblesPorId(Long id, LocalDate fechaInicioReserva, LocalDate fechafinReserva) {
        return iProductoRepository.buscarPorFechasDisponiblesPorId(id,fechaInicioReserva,fechafinReserva);
    }

    @Override
    public List<ProductoDTO> buscarPorCategoria(String categoria) {
        return iProductoRepository.buscarPorCategoria(categoria);
    }

    @Override
    public List<ProductoDTO> listarProductosFinal() {
        return iProductoRepository.listarProductosFinal();
    }
    @Override
    public List<ProductoDTO> buscarProductos(String producto) {
        return iProductoRepository.buscarProductos(producto);
    }

}

