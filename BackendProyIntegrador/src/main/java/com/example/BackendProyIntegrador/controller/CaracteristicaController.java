package com.example.BackendProyIntegrador.controller;

import com.example.BackendProyIntegrador.dto.CaracteristicaDTO;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.service.ICaracteristicaService;
import com.example.BackendProyIntegrador.service.impl.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/caracteristicas")

public class CaracteristicaController {

    @Autowired
    ICaracteristicaService iCaracteristicaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar( CaracteristicaDTO caracterista) {
        iCaracteristicaService.guardar(caracterista);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<CaracteristicaDTO> traerTodos(){
        return iCaracteristicaService.listarTodos();
    }

    @GetMapping("/{id}")
    public CaracteristicaDTO traerPorId(@PathVariable Long id) throws Exception {
        return iCaracteristicaService.listarId(id);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        ResponseEntity<String> response = null;
        iCaracteristicaService.eliminar(id);
        response=ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(CaracteristicaDTO caracteristica){
        iCaracteristicaService.actualizar(caracteristica);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
