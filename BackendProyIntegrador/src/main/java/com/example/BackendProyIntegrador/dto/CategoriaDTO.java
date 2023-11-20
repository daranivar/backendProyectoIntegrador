package com.example.BackendProyIntegrador.dto;

public class CategoriaDTO {

    private Long id;
    private String nombre;

    private String descripcion;
    private String urlimagen;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nombre, String descripcion, String urlimagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
    }

    public CategoriaDTO(Long id, String nombre, String descripcion, String urlimagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
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

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
