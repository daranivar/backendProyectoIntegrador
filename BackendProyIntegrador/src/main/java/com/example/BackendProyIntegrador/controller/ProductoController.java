package com.example.BackendProyIntegrador.controller;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoDTO producto){
        productoService.guardar(producto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<ProductoDTO> traerTodos(){
        return productoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProductoDTO traerPorId(@PathVariable Long id) throws Exception {
        return productoService.listarId(id);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        ResponseEntity<String> response = null;
        productoService.eliminar(id);
        response=ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoDTO producto){
        productoService.actualizar(producto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
