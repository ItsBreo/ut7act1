package josue.mascotas.act1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import josue.mascotas.act1.model.mascota;


public interface mascotaRepository extends JpaRepository<mascota, Long>{
    
}
