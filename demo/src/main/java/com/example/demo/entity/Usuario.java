package com.example.demo.entity;

import com.example.demo.enums.Estado;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Identificador único del registro de usuarios.")
    private Long id;

    @Column(name = "username", nullable = false)
    @Comment("Nombre del usuario")
    private String username;

    @Column(name = "password", nullable = true)
    @Comment("Password del usuario")
    private String password;

    @Column(name = "email", nullable = true)
    @Comment("Email del usuario")
    private String email;

    @Column(name = "estado", nullable = true)
    @Enumerated(EnumType.STRING)
    @Comment("Estado actual del usuario")
    private Estado estado;

}
