package com.clinicasocorro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "personas")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "dni", length = 8, unique = true)
    private String dni;

    @Column(name = "nombres", length = 100)
    private String nombres;

    @Column(name = "apellidos", length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "genero", length = 20)
    private String genero;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "direccion", length = 255)
    private String direccion;

    // Relación Uno a Uno con Usuario
    // Usamos @JoinColumn porque Persona tiene la llave foránea 'id_usuario'
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}