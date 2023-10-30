package com.example.BackendProyIntegrador.service;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IProductoService {

    void guardar (ProductoDTO producto);

    List<ProductoDTO> listarTodos();

    ProductoDTO listarId (Long id) throws Exception;

    void eliminar (Long id);

    void actualizar (ProductoDTO producto);



}
