package com.example.BackendProyIntegrador.repository;

import com.example.BackendProyIntegrador.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
}
