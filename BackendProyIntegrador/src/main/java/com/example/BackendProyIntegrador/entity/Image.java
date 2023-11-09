package com.example.BackendProyIntegrador.entity;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "productos_id", referencedColumnName = "id")
    private Producto producto;

    public Image() {
    }

    public Image(Long id, String url) {
        this.id = id;

        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
