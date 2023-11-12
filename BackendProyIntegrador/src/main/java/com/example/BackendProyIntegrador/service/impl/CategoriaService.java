package com.example.BackendProyIntegrador.service.impl;

import com.example.BackendProyIntegrador.dto.CategoriaDTO;
import com.example.BackendProyIntegrador.entity.Categoria;
import com.example.BackendProyIntegrador.repository.ICategoriaRepository;
import com.example.BackendProyIntegrador.service.ICategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    ICategoriaRepository iCategoriaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardar(CategoriaDTO categoria) {
        Categoria categoriaNueva = mapper.convertValue(categoria, Categoria.class);
        iCategoriaRepository.save(categoriaNueva);
    }

    @Override
    public List<CategoriaDTO> listarTodos() {
        List<CategoriaDTO> listar = new ArrayList<>();
        for (Categoria c: iCategoriaRepository.findAll()) {
            listar.add(mapper.convertValue(c, CategoriaDTO.class));
        }

        return listar;
    }

    @Override
    public CategoriaDTO listarId(Long id) throws Exception {
        Optional<Categoria> found = iCategoriaRepository.findById(id);
        if(found.isPresent())
            return mapper.convertValue(found, CategoriaDTO.class);
        else
            throw new Exception("La categoria no existe");
    }

    @Override
    public void eliminar(Long id) {
        iCategoriaRepository.deleteById(id);
    }

    @Override
    public void actualizar(CategoriaDTO categoria) {
        guardar(categoria);
    }
}
