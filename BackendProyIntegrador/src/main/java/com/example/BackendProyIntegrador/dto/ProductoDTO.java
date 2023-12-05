package com.example.BackendProyIntegrador.dto;

import com.example.BackendProyIntegrador.entity.Caracteristica;
import com.example.BackendProyIntegrador.entity.Categoria;
import com.example.BackendProyIntegrador.entity.Imagen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private String imagen;

    private String precio;

    private Categoria categoria;

    private Set<Caracteristica> caracteristicas = new HashSet<Caracteristica>();

    private List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();

    private List<Imagen> imagenes = new ArrayList<Imagen>();


    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, String descripcion, String imagen, String precio, Categoria categoria, Set<Caracteristica> caracteristicas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
    }

    public ProductoDTO(Long id, String nombre, String descripcion, String imagen, String precio, Categoria categoria, Set<Caracteristica> caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
}
