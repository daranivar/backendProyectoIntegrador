package com.example.BackendProyIntegrador.service;

import com.example.BackendProyIntegrador.dto.ProductoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IProductoService {

    void guardar (ProductoDTO producto);

    List<ProductoDTO> listarTodos();

    ProductoDTO listarId (Long id) throws Exception;

    void eliminar (Long id);

    void actualizar (ProductoDTO producto);

    List<ProductoDTO> buscarPorCategoria(String categoria);

    List<ProductoDTO> listarProductosFinal();

    ProductoDTO buscarProductoPorId(Long id);


    List<ProductoDTO> buscarPorFechasDisponibles(LocalDate fechaInicioReserva, LocalDate fechafinReserva);

    ProductoDTO buscarPorFechasDisponiblesPorId(Long id,LocalDate fechaInicioReserva, LocalDate fechafinReserva);



}
