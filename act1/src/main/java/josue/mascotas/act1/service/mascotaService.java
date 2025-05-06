package josue.mascotas.act1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import josue.mascotas.act1.model.mascota;
import josue.mascotas.act1.repository.mascotaRepository;

import java.util.List;
import java.util.Optional;
// Marca esta clase como un servicio de Spring (lógica de negocio)
@Service
public class mascotaService {

    @Autowired // Inyecta automáticamente el repositorio de Mascotas en este servicio
    private mascotaRepository mascotaRepository;


     // Método para listar todas las mascotas en la base de datos
    public List<mascota> listarTodas() {
        return mascotaRepository.findAll();
    }
    // Método para buscar una mascota por ID en la base de datos
    public Optional<mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }

     // Método para guardar una mascota
    public mascota guardar(mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    
    // Método para actualizar las mascotas en la base de datos
    public mascota actualizar(Long id, mascota nuevaMascota) {
        nuevaMascota.setId(id); // Setear el ID de la mascota que se está actualizando
        return mascotaRepository.save(nuevaMascota); // Guardar la mascota actualizada
    }
    /**
     * Elimina una mascota de la base de datos utilizando su ID.
     * 
     * @param id El identificador único de la mascota a eliminar.
     */
    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }
}
