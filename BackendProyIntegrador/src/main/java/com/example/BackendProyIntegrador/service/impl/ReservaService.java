package com.example.BackendProyIntegrador.service.impl;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.dto.ReservaDTO;
import com.example.BackendProyIntegrador.entity.Producto;
import com.example.BackendProyIntegrador.entity.Reserva;
import com.example.BackendProyIntegrador.repository.IProductoRepository;
import com.example.BackendProyIntegrador.repository.IReservaRepository;
import com.example.BackendProyIntegrador.service.IReservaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    IReservaRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearReserva(ReservaDTO reserva) {
        Reserva reservaNueva = mapper.convertValue(reserva, Reserva.class);
        repository.save(reservaNueva);
    }

    @Override
    public List<ReservaDTO> listarReservas() {
        List<ReservaDTO> listar = new ArrayList<>();
        for (Reserva r: repository.findAll()) {
            listar.add(mapper.convertValue(r, ReservaDTO.class));
        }

        return listar;
    }

    @Override
    public ReservaDTO listarPorId(Long id) throws Exception {
        Optional<Reserva> found = repository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, ReservaDTO.class);
        else
            throw new Exception("La reserva no existe");
    }


  /*  @Override
    public List<ReservaDTO> listarReservasPorIdUsuario(Long id) {
        return repository.listarReservasPorIdUsuario(id);
    }*/
}
