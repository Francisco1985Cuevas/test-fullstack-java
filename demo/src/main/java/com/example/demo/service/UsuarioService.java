package com.example.demo.service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.enums.Estado;

import java.util.List;

public interface UsuarioService {
    Long create(UsuarioDTO usuarioDTO);

    void update(Long id, UsuarioDTO usuarioDTO) throws Exception;

    void delete(final Long id);

    List<UsuarioDTO> findAll() throws Exception;

    UsuarioDTO getByUsername(String username) throws Exception;

    UsuarioDTO getByEstado(Estado estado) throws Exception;

    boolean validaUsuario(UsuarioDTO usuarioDTO) throws Exception;
}
