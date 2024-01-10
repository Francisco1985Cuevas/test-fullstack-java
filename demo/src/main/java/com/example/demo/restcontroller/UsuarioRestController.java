package com.example.demo.restcontroller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@Slf4j
public class UsuarioRestController {
    @Autowired
    private UsuarioService service;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return ResponseEntity.ok(service.create(usuarioDTO));
        } catch (Exception e) {
            log.error("Error al crear nuevo usuario: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            service.update(id, usuarioDTO);
            return ResponseEntity.ok("Actualizado Exitosamente!");
        } catch (Exception e) {
            log.error("Error al actualizar usuario: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Eliminado Exitosamente!");
        } catch (Exception e) {
            log.error("Error al eliminar: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            log.error("Error al listar usuarios: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByNombre")
    public ResponseEntity<?> getByNombre(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return ResponseEntity.ok(service.getByUsername(usuarioDTO.getUsername()));
        } catch (Exception e) {
            log.error("Error al buscar usuario por Nombre: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByEstado")
    public ResponseEntity<?> getByEstado(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return ResponseEntity.ok(service.getByEstado(usuarioDTO.getEstado()));
        } catch (Exception e) {
            log.error("Error al buscar usuario por Estado: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
