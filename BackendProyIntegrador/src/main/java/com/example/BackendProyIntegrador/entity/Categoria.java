package com.example.BackendProyIntegrador.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @SequenceGenerator(name= "categorize_sequence", sequenceName = "categorize_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categorize_sequence")
    private Long id;
    private String nombre;
    private String descripcion;
    private String urlimagen;
    @ElementCollection
    private List<String> urlsImagenes;


    public Categoria() {
    }

    public Categoria(Long id, String nombre, String descripcion, String urlimagen, List<String> urlsImagenes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
        this.urlsImagenes = urlsImagenes;
    }

    public Categoria(String nombre, String descripcion, String urlimagen, List<String> urlsImagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlimagen = urlimagen;
        this.urlsImagenes = urlsImagenes;
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

    public List<String> getUrlsImagenes() {
        return urlsImagenes;
    }

    public void setUrlsImagenes(List<String> urlsImagenes) {
        this.urlsImagenes = urlsImagenes;
    }
}
