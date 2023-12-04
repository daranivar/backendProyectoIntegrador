package com.example.BackendProyIntegrador.repository;

import com.example.BackendProyIntegrador.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Long> {
}
