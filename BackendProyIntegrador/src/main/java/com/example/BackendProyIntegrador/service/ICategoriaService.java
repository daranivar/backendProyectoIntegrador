package com.example.BackendProyIntegrador.service;

import com.example.BackendProyIntegrador.dto.CategoriaDTO;
import com.example.BackendProyIntegrador.dto.ProductoDTO;

import java.util.List;

public interface ICategoriaService {

    void guardar (CategoriaDTO categoria);

    List<CategoriaDTO> listarTodos();

    CategoriaDTO listarId (Long id) throws Exception;

    void eliminar (Long id);

    void actualizar (CategoriaDTO categoria);

}
