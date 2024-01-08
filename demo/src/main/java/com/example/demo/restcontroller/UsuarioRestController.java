package com.example.demo.restcontroller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RestControlador para gestionar las operaciones relacionadas con los usuarios.
 * Este Restcontrolador maneja solicitudes relacionadas con la gestión de usuarios, como
 * la creación, actualización y eliminación de usuarios.
 */
@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioRestController {
    @Autowired
    private UsuarioService service;

    /**
     * Crea un nuevo registro de Usuarios en la base de datos.
     * @param UsuarioDTO DTO que contiene la información del nuevo Usuario.
     * @return ResponseEntity
     */
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UsuarioDTO usuarioDTO) {
        log.info("username: {}", usuarioDTO.getUsername());
        log.info("RestController de usuarios - Inicia proceso de Guardar en Base de datos el usuario");

        try {
            return ResponseEntity.ok(service.create(usuarioDTO)); //retorno el id creado.
        } catch (Exception e) {
            log.error("Error en la petición para crear nuevo Usuario: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(name = "id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
        log.info("username: {}", usuarioDTO.getUsername());
        log.info("RestController de usuarios - Inicia proceso de Actualizacion en Base de datos del usuario");
        try {
            service.update(id, usuarioDTO);
            return ResponseEntity.ok("Actualizado Exitosamente!");
        } catch (Exception e) {
            log.error("Error en la petición actualizar usuario existente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Eliminado Exitosamente!");
        } catch (Exception e) {
            log.error("Error en la petición eliminar: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<?> list() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            log.error("Error en la petición de listado de Usuarios: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByNombre")
    public ResponseEntity<?> getByNombre(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return ResponseEntity.ok(service.getByUsername(usuarioDTO.getUsername()));
        } catch (Exception e) {
            log.error("Error en la petición de buscar usuario por Nombre: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByEstado")
    public ResponseEntity<?> getByEstado(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return ResponseEntity.ok(service.getByEstado(usuarioDTO.getEstado()));
        } catch (Exception e) {
            log.error("Error en la petición de buscar usuario por Estado: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
