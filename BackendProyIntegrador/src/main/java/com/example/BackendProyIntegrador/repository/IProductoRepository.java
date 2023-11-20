package com.example.BackendProyIntegrador.repository;

import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long>{
    //@Query(value = "SELECT p.id_producto,p.nombre,p.descripcion,p.imagen FROM Productos p", nativeQuery = true)
    //List<ProductoDTO> listarTodos();
    //@Query("SELECT p FROM Productos p WHERE p.idProducto = :id")
    //ProductoDTO listarId(Long id);


}
