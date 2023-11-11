package com.example.BackendProyIntegrador.controller;


import com.example.BackendProyIntegrador.login.AppUser;
import com.example.BackendProyIntegrador.login.AppUsuarioRoles;
import com.example.BackendProyIntegrador.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registro")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(AppUser appUser) {
        appUser.setAppUsuarioRoles(AppUsuarioRoles.USER);
        userRepository.save(appUser);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public List<AppUser> traerTodos(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> traerPorId(@PathVariable Long id) throws Exception {
        return userRepository.findById(id);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        ResponseEntity<String> response = null;
        userRepository.deleteById(id);
        response=ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody AppUser appUser){
        userRepository.save(appUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
