package com.example.BackendProyIntegrador.service;

import com.example.BackendProyIntegrador.config.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    void guardar (ProductoDTO producto);

    List<ProductoDTO> listarTodos();

    ProductoDTO listarId (Long id) throws Exception;

    void eliminar (Long id);

    void actualizar (ProductoDTO producto);



}
