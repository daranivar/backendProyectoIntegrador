package com.example.BackendProyIntegrador.service;

import com.example.BackendProyIntegrador.entity.ProductImage;

import java.util.List;

public interface IProductImageService {
    ProductImage createProductImage(ProductImage productImage);

    void updateProductImage(ProductImage productImage);

    void deleteProductImage(Long id) throws Exception;

    ProductImage findProductImageById(Long id) throws Exception;

    List<ProductImage> getAllProductImages();
}
