package com.example.demo.dto;

import com.example.demo.enums.Estado;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message="El nombre de usuario no puede estar vacío")
    @NotBlank(message="El nombre de usuario no puede estar en blanco")
    @Size(min=2, max=255, message="El nombre de usuario debe tener entre 2 y 255 caracteres.")
    private String username;

    @NotEmpty(message="El password no puede estar vacío")
    @NotBlank(message="El password no puede estar en blanco")
    @Size(min=2, max=255, message="El password debe tener minimo 2 caracteres.")
    private String password;

    @NotEmpty(message="El email no puede estar vacío")
    @NotBlank(message="El email no puede estar en blanco")
    @Size(min=2, max=255, message="El email debe tener minimo 2 caracteres.")
    private String email;

    @Enumerated(EnumType.STRING)
    private Estado estado;
}
