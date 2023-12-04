package com.example.BackendProyIntegrador.repository;

import com.example.BackendProyIntegrador.dto.ReservaDTO;
import com.example.BackendProyIntegrador.entity.Reserva;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {
  /*  @Query("SELECT r FROM Reserva r JOIN r.app_user_id u WHERE u.id = (:id)")
    List<ReservaDTO> listarReservasPorIdUsuario(Long id);*/

}
