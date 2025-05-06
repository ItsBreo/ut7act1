package josue.mascotas.act1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import josue.mascotas.act1.model.mascota;

// Marca esta clase como un repositorio de Spring para acceder a la base de datos
public interface mascotaRepository extends JpaRepository<mascota, Long>{
    
}
