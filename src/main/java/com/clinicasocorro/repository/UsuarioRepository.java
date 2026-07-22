package com.clinicasocorro.repository;

import com.clinicasocorro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta para obtener usuarios por su nombre de usuario (útil para el Login)
    Usuario findByUsername(String username);

    // Consulta personalizada para obtener el staff médico activo
    // Filtramos por el nombre del rol 'MEDICO' y estado 'ACTIVO'
    // Cambia String por Integer en el parámetro estado
    @Query("SELECT u FROM Usuario u WHERE u.rol.nombreRol = :nombreRol AND u.estado = :estado")
    List<Usuario> findByRolAndEstado(@Param("nombreRol") String nombreRol, @Param("estado") Integer estado);
}