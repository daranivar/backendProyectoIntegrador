package com.example.BackendProyIntegrador.service;



import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.dto.ReservaDTO;
import com.example.BackendProyIntegrador.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {

    void crearReserva(ReservaDTO reserva);

    List<ReservaDTO> listarReservas();

    ReservaDTO listarPorId (Long id) throws Exception;

    /*List<ReservaDTO> listarReservasPorIdUsuario(Long id);*/



}
