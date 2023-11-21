package com.example.BackendProyIntegrador.entity;

import javax.persistence.*;

@Entity
@Table(name="caracteristicas")
public class Caracteristica {
    @Id
    @SequenceGenerator(name= "caracteristica_secuencia", sequenceName = "caracteristica_secuencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "caracteristica_secuencia")
    private Long id;
    private String nombre;
    private String icono;

    public Caracteristica() {
    }

    public Caracteristica(Long id, String nombre, String icono) {
        this.id = id;
        this.nombre = nombre;
        this.icono = icono;
    }

    public Caracteristica(String nombre, String icono) {
        this.nombre = nombre;
        this.icono = icono;
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
