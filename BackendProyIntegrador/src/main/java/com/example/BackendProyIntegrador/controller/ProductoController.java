package com.example.BackendProyIntegrador.controller;
import org.apache.log4j.Logger;
import com.amazonaws.services.s3.AmazonS3;
import com.example.BackendProyIntegrador.dto.ProductoDTO;
import com.example.BackendProyIntegrador.service.impl.AWSService;
import com.example.BackendProyIntegrador.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    public static final Logger logger = Logger.getLogger(ProductoController.class);

    @Value("${aws.s3.bucket}")
    private String bucketName;
    @Autowired
    private AWSService awsService;

    @Autowired
    private AmazonS3 amazonS3;

    /*@Autowired
    private Categoria categoria;*/



    @Autowired
    IProductoService productoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ProductoDTO producto) {
        productoService.guardar(producto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<ProductoDTO> traerTodos(){
        return productoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProductoDTO traerPorId(@PathVariable Long id) throws Exception {
        return productoService.listarId(id);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        ResponseEntity<String> response = null;
        productoService.eliminar(id);
        response=ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoDTO producto){
        productoService.actualizar(producto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarProductoParcial(@PathVariable Long id, @RequestBody Map<String, Object> producto){
      ProductoDTO productoExistente = productoService.buscarProductoPorId(id);
              for (Map.Entry<String, Object> entry : producto.entrySet()){
                  String campo = entry.getKey();
                  Object valor = entry.getValue();
                  switch (campo){
                      case "nombre":
                          productoExistente.setNombre((String) valor);
                          break;
                      case "descripcion":
                          productoExistente.setDescripcion((String) valor);
                          break;
                      case "imagen":
                          productoExistente.setImagen((String) valor);
                          break;
                      case "precio":
                          productoExistente.setPrecio((String) valor);
                          break;
                  }
              }
        productoService.guardar(productoExistente);
        return ResponseEntity.ok(HttpStatus.OK);
    }


   /* @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file, @ModelAttribute ProductoDTO producto){
        //productoService.guardar(producto);
        awsService.uploadFile(file);
       //GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, file.getOriginalFilename());
       //String imageUrl = generatePresignedUrlRequest.toString();
       String fileName = file.getOriginalFilename();
       String fileUrl = amazonS3.getUrl(bucketName,fileName).toString();
       String response = "El archivo" + file.getOriginalFilename() + " fue cargado correctamente a S3 ";
       //Image image = new Image();
       //image.setUrl(fileUrl);
       // iImageRepository.save(image);
       producto.setImagen(fileUrl);
       productoService.guardar(producto);
       return new ResponseEntity<String>(response,HttpStatus.OK);
    }
*/
    /*ENDPOINT DE BUSQUEDAS QUERY*/

    @GetMapping("/query/{id}")
    public ResponseEntity<ProductoDTO> buscarPorId(@PathVariable Long id){
        if(productoService.buscarProductoPorId(id).getId().equals(id)){
            return ResponseEntity.ok(productoService.buscarProductoPorId(id));
        }
        else {
            logger.error("El producto con el id "+id+" no se encuentra");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<ProductoDTO>> buscarPorCategoria(@RequestParam("categoria") String categoria){
        if(!productoService.buscarPorCategoria(categoria).isEmpty()){
            return ResponseEntity.ok(productoService.buscarPorCategoria(categoria));
        } else {
            logger.error("La categoria consultada no cuenta con productos");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/query/final")
    public List<ProductoDTO> listarProductosFinal(){
        return productoService.listarProductosFinal();
    }

    @GetMapping("/query/buscarproducto")
    public ResponseEntity<List<ProductoDTO>> buscarProductos(@RequestParam("producto") String producto){
        if(!productoService.buscarProductos(producto).isEmpty()){
            return ResponseEntity.ok(productoService.buscarProductos(producto));
        } else {
            logger.error("Los productos consultados no se encuentran");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
