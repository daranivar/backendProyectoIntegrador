package com.example.BackendProyIntegrador.service.impl;

import org.springframework.web.multipart.MultipartFile;

public interface IAWS3Service {
    void uploadFile(MultipartFile file);
}
