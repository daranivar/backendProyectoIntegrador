package com.example.BackendProyIntegrador.entity;

import javax.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {
    @Id
    @SequenceGenerator(name= "imagen_secuencia", sequenceName = "imagen_secuencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "imagen_secuencia")
    private Long id;

    private String titulo;

    private String urlImagen;

    public Imagen() {
    }

    public Imagen(Long id, String titulo, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.urlImagen = urlImagen;
    }

    public Imagen(String titulo, String urlImagen) {
        this.titulo = titulo;
        this.urlImagen = urlImagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}
