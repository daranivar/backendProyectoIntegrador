package com.example.BackendProyIntegrador.service.impl;

import com.example.BackendProyIntegrador.entity.Image;
import com.example.BackendProyIntegrador.entity.Producto;
import com.example.BackendProyIntegrador.repository.IImageRepository;
import com.example.BackendProyIntegrador.repository.IProductoRepository;
import com.example.BackendProyIntegrador.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.mq.model.BadRequestException;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements IImageService {

    @Autowired
    IImageRepository iImageRepository;

    @Autowired
    IProductoRepository iProductoRepository;

    @Override
    public List<Image> getAllimages() {
        return iImageRepository.findAll();
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        return iImageRepository.findById(id);
    }

    @Override
    public Image saveImage(Image image, Long productoId) {
        Optional<Producto> optionalProducto = iProductoRepository.findById(productoId);

        image.setProducto(optionalProducto.get());
        return iImageRepository.save(image);
    }

    @Override
    public Image updateImage(Image image, Long productoId) throws BadRequestException {
        Optional<Image> imageBdd = iImageRepository.findById(image.getId());
        boolean productoDidntChange = imageBdd.get().getProducto().equals(productoId);

        imageBdd.get().setTitle(image.getTitle());
        imageBdd.get().setUrl(image.getUrl());

        return iImageRepository.save(imageBdd.get());
    }

    @Override
    public void deleteImageById(Long id) {
        iImageRepository.deleteById(id);
    }
}
