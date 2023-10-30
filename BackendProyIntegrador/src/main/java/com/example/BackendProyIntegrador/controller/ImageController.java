package com.example.BackendProyIntegrador.controller;

import com.example.BackendProyIntegrador.entity.Image;
import com.example.BackendProyIntegrador.repository.IImageRepository;
import com.example.BackendProyIntegrador.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<List<Image>> getAllimages(){
        return ResponseEntity.ok(imageService.getAllimages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Optional<Image> findImage = imageService.getImageById(id);
        if (findImage.isPresent()) {
            return ResponseEntity.ok(findImage.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/create/{productId}")
    public ResponseEntity<Image> createImage(@RequestBody Image image, @PathVariable Long productId) {
        return ResponseEntity.ok(imageService.saveImage(image,productId));
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateImage(@RequestBody Image image, @PathVariable Long productId) throws Exception {
        Optional<Image> findImage = imageService.getImageById(image.getId());
        if (findImage.isPresent()) {
            return ResponseEntity.ok(imageService.updateImage(image,productId));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La imagen con ID: " + image.getId() + " no se encuentra");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        if (imageService.getImageById(id).isPresent()) {
            imageService.deleteImageById(id);
            return ResponseEntity.ok("Se eliminó con éxito la imagen con ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la imagen con ID: " + id);
    }



}
