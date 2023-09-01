package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     // Método personalizado para obtener una lista de usuarios ordenados por un campo específico (por ejemplo, nombre)
    @Query("SELECT u FROM Usuario u ORDER BY u.nombre ASC")
    List<Usuario> obtenerUsuariosOrdenadosPorNombre();
  
    // Inyecta tu repositorio de usuarios aqu
    
    // Otros métodos del servicio
}

