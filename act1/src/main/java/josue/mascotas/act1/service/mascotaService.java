package josue.mascotas.act1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import josue.mascotas.act1.model.mascota;
import josue.mascotas.act1.repository.mascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class mascotaService {
    @Autowired
    private mascotaRepository mascotaRepository;

    public List<mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    public Optional<mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    public mascota guardar(mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public mascota actualizar(Long id, mascota nuevaMascota) {
        return mascotaRepository.findById(id).map(m -> {
            m.setNombre(nuevaMascota.getNombre());
            m.setEspecie(nuevaMascota.getEspecie());
            m.setEdad(nuevaMascota.getEdad());
            m.setAdoptado(nuevaMascota.isAdoptado());
            return mascotaRepository.save(m);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }
}
