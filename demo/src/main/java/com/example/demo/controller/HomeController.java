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
@RequestMapping("/etica")
@Slf4j
public class HomeController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public String login(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "login";
    }

    @PostMapping("/login")
    public String create(@Valid UsuarioDTO usuarioDTO, BindingResult result, Model model) {
        try {
            if(service.validaUsuario(usuarioDTO)) {
                model.addAttribute("usuarios", service.findAll());
                return "listado";
            } else {
                return "/";
            }
        } catch (Exception e) {
            log.error("Error en la petición login: {}", e.getMessage());
            return "error";
        }
    }


}
