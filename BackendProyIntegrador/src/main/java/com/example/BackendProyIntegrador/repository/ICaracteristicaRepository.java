package com.example.BackendProyIntegrador.repository;

import com.example.BackendProyIntegrador.entity.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaracteristicaRepository extends JpaRepository<Caracteristica, Long> {

}
