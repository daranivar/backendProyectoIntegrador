package com.example.BackendProyIntegrador.controller;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.dto.ReservaDTO;
import com.example.BackendProyIntegrador.entity.Reserva;
import com.example.BackendProyIntegrador.service.impl.ProductoService;
import com.example.BackendProyIntegrador.service.impl.ReservaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservas")
public class ReservaController {

    public static final Logger logger = Logger.getLogger(ReservaController.class);

    @Autowired
    ReservaService reservaService;

    @Autowired
    ProductoService productoService;

    @PostMapping("/guardar")
    public ResponseEntity<String> crearReserva(@RequestBody ReservaDTO reserva) throws Exception {
        reservaService.crearReserva(reserva);
        logger.info("La reserva fue creada");
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva creada exitosamente");
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<ProductoDTO> crearReserva(@PathVariable Long id, @RequestBody ReservaDTO reserva) throws Exception {
        ProductoDTO producto = productoService.buscarProductoPorId(id);
        if(productoService.buscarPorFechasDisponiblesPorId(id,reserva.getFechaInicioReserva(),reserva.getFechafinReserva()).getId().equals(id)){
            reservaService.crearReserva(reserva);
            logger.info("La reserva fue creada");
            producto.getReservas().add(reserva);
            productoService.actualizar(producto);
            return ResponseEntity.ok(productoService.buscarProductoPorId(id));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/todos")
    public List<ReservaDTO> listarReservas(){
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> listarPorId(@PathVariable Long id) throws Exception{
        if(reservaService.listarPorId(id).equals(id)){
            return ResponseEntity.ok(reservaService.listarPorId(id));
        }
        else {
            logger.error("La reserva con el id "+id+" no se encuentra");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
   /* @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ReservaDTO>> buscarPorIdUsuario(@PathVariable Long id){
        if(!reservaService.listarReservasPorIdUsuario(id).isEmpty()){
            return ResponseEntity.ok(reservaService.listarReservasPorIdUsuario(id));
        }
        else {
            logger.error("El usuario con id "+id+" no cuenta con reservas");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }*/

}
