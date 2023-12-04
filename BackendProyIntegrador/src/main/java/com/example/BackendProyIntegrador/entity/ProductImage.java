package com.example.BackendProyIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;


@Entity
@Table(name = "ProductImage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "image_data")
    private byte[] productImage;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public ProductImage() {
    }

    public ProductImage(byte[] productImage, Producto producto) {
        this.productImage = productImage;
        this.producto = producto;
    }

    public ProductImage(Long id, byte[] productImage, Producto producto) {
        this.id = id;
        this.productImage = productImage;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
