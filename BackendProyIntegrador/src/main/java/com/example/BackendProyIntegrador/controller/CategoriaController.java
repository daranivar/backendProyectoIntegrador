package com.example.BackendProyIntegrador.controller;


import com.amazonaws.services.s3.AmazonS3;
import com.example.BackendProyIntegrador.dto.CategoriaDTO;
import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.service.ICategoriaService;
import com.example.BackendProyIntegrador.service.IProductoService;
import com.example.BackendProyIntegrador.service.impl.AWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Value("${aws.s3.bucket}")
    private String bucketName;
    @Autowired
    private AWSService awsService;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    ICategoriaService categoriaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody CategoriaDTO categoria) {
        categoriaService.guardar(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<CategoriaDTO> traerTodos(){
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaDTO traerPorId(@PathVariable Long id) throws Exception {
        return categoriaService.listarId(id);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        ResponseEntity<String> response = null;
        categoriaService.eliminar(id);
        response=ResponseEntity.status(HttpStatus.OK).body("Eliminada");
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(CategoriaDTO categoria){
        categoriaService.actualizar(categoria);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file, CategoriaDTO categoria){
        awsService.uploadFile(file);
        String fileName = file.getOriginalFilename();
        String fileUrl = amazonS3.getUrl(bucketName,fileName).toString();
        String response = "El archivo" + file.getOriginalFilename() + " fue cargado correctamente a S3 ";
        categoria.setUrlimagen(fileUrl);
        categoriaService.guardar(categoria);



        return new ResponseEntity<String>(response,HttpStatus.OK);

    }
}
