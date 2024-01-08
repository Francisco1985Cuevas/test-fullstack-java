package com.example.demo.repository;

import com.example.demo.entity.Usuario;
import com.example.demo.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Metodo personalizado para buscar por nombre
    Optional<Usuario> findByUsername(String username);

    //Metodo personalizado para buscar por estado
    Optional<Usuario> findByEstado(Estado estado);
}
