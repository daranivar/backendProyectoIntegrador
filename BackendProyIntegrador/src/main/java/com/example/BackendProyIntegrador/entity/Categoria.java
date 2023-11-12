package com.example.BackendProyIntegrador.entity;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String nombre;
    private String urlimagen;

    public Categoria() {
    }

    public Categoria(Long id, String nombre, String urlimagen) {
        this.id = id;
        this.nombre = nombre;
        this.urlimagen = urlimagen;
    }

    public Categoria(String nombre, String urlimagen) {
        this.nombre = nombre;
        this.urlimagen = urlimagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
