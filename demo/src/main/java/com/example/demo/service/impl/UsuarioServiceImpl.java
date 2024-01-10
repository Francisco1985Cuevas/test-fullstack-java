package com.example.demo.service.impl;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entity.Usuario;
import com.example.demo.enums.Estado;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de usuarios.
 */
@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Override
    public Long create(final UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setEmail(usuarioDTO.getEmail());
        //por default al crear un nuevo usuario, le asigno el estado Activo.
        usuario.setEstado(Estado.ACTIVO);

        return repository.save(usuario).getId();
    }

    @Override
    public void update(Long id, UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = repository.findById(id).orElseThrow(Exception::new);
        if (usuario != null) {
            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setEmail(usuarioDTO.getEmail());
            repository.save(usuario);
        } else {
            throw new Exception("No se encontro usuario, No se puede actualizar el registro");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<UsuarioDTO> findAll() throws Exception {
        try {
            List<Usuario> usuarioList = repository.findAll(Sort.by("id"));
            List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

            for (Usuario usuario : usuarioList) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(usuario.getId());
                usuarioDTO.setUsername(usuario.getUsername());
                usuarioDTO.setPassword(usuario.getPassword());
                usuarioDTO.setEmail(usuario.getEmail());
                usuarioDTO.setEstado(usuario.getEstado());

                // Agregar el usuarioDTO a la lista
                usuarioDTOList.add(usuarioDTO);
            }
            return usuarioDTOList;


        } catch (Exception e) {
            throw new Exception("Error en el service de listado de Marcas");
        }
    }


    @Override
    public UsuarioDTO getByUsername(String username) throws Exception {
        try {
            Optional<Usuario> usuario = repository.findByUsername(username);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.get().getId());
            usuarioDTO.setUsername(usuario.get().getUsername());
            usuarioDTO.setPassword(usuario.get().getPassword());
            usuarioDTO.setEmail(usuario.get().getEmail());
            usuarioDTO.setEstado(usuario.get().getEstado());

            return usuarioDTO;
        } catch (Exception e) {
            log.error("Error en el service buscar usuario por Nombre: {}", e.getMessage());
            throw new Exception("Error en el service buscar usuario por Nombre");
        }
    }

    @Override
    public UsuarioDTO getByEstado(Estado estado) throws Exception {
        try {
            Optional<Usuario> usuario = repository.findByEstado(estado);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.get().getId());
            usuarioDTO.setUsername(usuario.get().getUsername());
            usuarioDTO.setPassword(usuario.get().getPassword());
            usuarioDTO.setEmail(usuario.get().getEmail());
            usuarioDTO.setEstado(usuario.get().getEstado());

            return usuarioDTO;
        } catch (Exception e) {
            log.error("Error en el service buscar usuario por Estado: {}", e.getMessage());
            throw new Exception("Error en el service buscar usuario por Estado");
        }
    }

}
