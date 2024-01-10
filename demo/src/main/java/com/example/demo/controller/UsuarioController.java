package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/usuarios")
@Slf4j
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/list")
    public String list(Model model) {
        try {
            model.addAttribute("usuarios", service.findAll());
            return "listado";
        } catch (Exception e) {
            log.error("Error al listar usuarios: {}", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "nuevo";
    }
    @PostMapping("/create")
    public String create(@Valid UsuarioDTO usuarioDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            //UsuarioDTO dto = new UsuarioDTO();
            model.addAttribute("usuarioDTO", usuarioDTO);
            return "nuevo";
        }
        try {
            service.create(usuarioDTO);
            model.addAttribute("usuarios", service.findAll());
            return "listado";
        } catch (Exception e) {
            log.error("Error en la petición para crear nueva Marca: {}", e.getMessage());
            return "error";
        }
    }
    
}
