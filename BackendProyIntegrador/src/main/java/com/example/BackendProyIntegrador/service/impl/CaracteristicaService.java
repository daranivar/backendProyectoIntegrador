package com.example.BackendProyIntegrador.service.impl;

import com.example.BackendProyIntegrador.dto.CaracteristicaDTO;
import com.example.BackendProyIntegrador.entity.Caracteristica;
import com.example.BackendProyIntegrador.repository.ICaracteristicaRepository;
import com.example.BackendProyIntegrador.service.ICaracteristicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CaracteristicaService implements ICaracteristicaService {

    @Autowired
    ICaracteristicaRepository iCaracteristicaRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void guardar(CaracteristicaDTO caracteristica) {
        Caracteristica caracteristicaNueva = mapper.convertValue(caracteristica, Caracteristica.class);
        iCaracteristicaRepository.save(caracteristicaNueva);

    }

    @Override
    public List<CaracteristicaDTO> listarTodos() {
        List<CaracteristicaDTO> listar = new ArrayList<>();
        for (Caracteristica c: iCaracteristicaRepository.findAll()) {
            listar.add(mapper.convertValue(c, CaracteristicaDTO.class));
        }

        return listar;
    }

    @Override
    public CaracteristicaDTO listarId(Long id) throws Exception {
        Optional<Caracteristica> found = iCaracteristicaRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, CaracteristicaDTO.class);
        else
            throw new Exception("La caracteristica no existe");
    }

    @Override
    public void eliminar(Long id) {
        iCaracteristicaRepository.deleteById(id);
    }

    @Override
    public void actualizar(CaracteristicaDTO caracteristica) {
        guardar(caracteristica);

    }
}
