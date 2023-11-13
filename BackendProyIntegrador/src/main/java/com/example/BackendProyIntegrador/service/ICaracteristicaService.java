package com.example.BackendProyIntegrador.service;

import com.example.BackendProyIntegrador.dto.CaracteristicaDTO;


import java.util.List;

public interface ICaracteristicaService {

    void guardar (CaracteristicaDTO caracteristica);

    List<CaracteristicaDTO> listarTodos();

    CaracteristicaDTO listarId (Long id) throws Exception;

    void eliminar (Long id);

    void actualizar (CaracteristicaDTO caracteristica);

}
