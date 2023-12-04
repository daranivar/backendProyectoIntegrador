package com.example.BackendProyIntegrador.entity;


import com.example.BackendProyIntegrador.dto.ReservaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @SequenceGenerator(name= "producto_secuencia", sequenceName = "producto_secuencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "producto_secuencia")
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String precio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Caracteristica> caracteristicas = new HashSet<Caracteristica>();

    @OneToMany
    private List<Reserva> reservas = new ArrayList<Reserva>();

    /*@OneToMany (mappedBy = "producto", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<Image> image;*/

    /*@ManyToMany(cascade={CascadeType.MERGE})
    @JoinTable(name="producto_caracteristica", joinColumns=@JoinColumn(name="id_producto"),
            inverseJoinColumns=@JoinColumn(name="id_caracteristica"))
    private List <Caracteristica> attributes;*/

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductImage> productImages;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, String imagen, String precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, String imagen, String precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
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

   /* public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }*/

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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }
}
