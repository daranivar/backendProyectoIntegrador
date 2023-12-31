package com.example.BackendProyIntegrador.controller;


import com.example.BackendProyIntegrador.login.AppUser;
import com.example.BackendProyIntegrador.login.AppUsuarioRoles;
import com.example.BackendProyIntegrador.login.UserRepository;
import com.example.BackendProyIntegrador.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/registro")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody AppUser appUser) {
        appUser.setAppUsuarioRoles(AppUsuarioRoles.USER);
        userRepository.save(appUser);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(password);
        userRepository.save(appUser);
        String confirmationLink = "https://www.cumbreski.com"; // Genera un enlace único aquí
        emailService.enviarMailConfirmacion(appUser.getEmail(), confirmationLink, appUser.getUsername(), appUser.getEmail());

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
