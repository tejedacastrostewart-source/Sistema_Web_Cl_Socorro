package com.clinicasocorro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "roles")
@Data // Esto genera automáticamente getters, setters, toString, etc.
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol", length = 50)
    private String nombreRol;

    // Relación inversa: Un rol puede pertenecer a muchos usuarios
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}