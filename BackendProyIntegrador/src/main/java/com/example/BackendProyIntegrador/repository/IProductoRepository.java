package com.example.BackendProyIntegrador.repository;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long>{
    @Query("SELECT p FROM Producto p JOIN p.categoria ca WHERE ca.nombre LIKE CONCAT ('%',:categoria,'%')")
    List<ProductoDTO> buscarPorCategoria(String categoria);
    @Query(value = "SELECT p.id,p.nombre,p.descripcion,p.imagen,p.precio FROM productos p", nativeQuery = true)
    List<ProductoDTO> listarProductosFinal();
    @Query("SELECT p FROM Producto p WHERE p.id = :id")
    ProductoDTO buscarProductoPorId(Long id);
    @Query("SELECT p FROM Producto p LEFT JOIN p.reservas r WHERE r.fechaInicioReserva NOT BETWEEN :fechaInicioReserva AND :fechafinReserva AND r.fechafinReserva NOT BETWEEN :fechaInicioReserva AND :fechafinReserva OR p.reservas IS EMPTY")
    List<ProductoDTO> buscarPorFechasDisponibles(LocalDate fechaInicioReserva, LocalDate fechafinReserva);
    @Query("SELECT p FROM Producto p JOIN p.reservas r WHERE p.id = :id AND r.fechaInicioReserva NOT BETWEEN :fechaInicioReserva AND :fechafinReserva AND r.fechafinReserva NOT BETWEEN :fechaInicioReserva AND :fechafinReserva")
    ProductoDTO buscarPorFechasDisponiblesPorId(Long id,LocalDate fechaInicioReserva, LocalDate fechafinReserva);
    @Query("SELECT p FROM Producto p where concat(p.id,' ',p.nombre,' ',p.descripcion,' ',p.imagen,' ',p.precio) like %?1%")
    List<ProductoDTO> buscarProductos(String producto);
}
