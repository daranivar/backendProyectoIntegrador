package com.example.BackendProyIntegrador.service;


import com.example.BackendProyIntegrador.entity.Image;
import software.amazon.awssdk.services.mq.model.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface IImageService {
    List<Image> getAllimages();
    Optional<Image> getImageById(Long id);
    Image saveImage(Image image, Long productoId);
    Image updateImage(Image image, Long productoId) throws BadRequestException;
    void deleteImageById(Long id);
}
