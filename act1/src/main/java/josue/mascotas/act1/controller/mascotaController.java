package josue.mascotas.act1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import josue.mascotas.act1.model.mascota;
import josue.mascotas.act1.service.mascotaService;

import java.util.List;

@RestController // Marca esta clase como un controlador REST que manejará las solicitudes HTTP
@RequestMapping("/api/v1/mascotas") // Define la URL base para todas las rutas en este controlador
public class mascotaController {

    @Autowired  // Inyecta automáticamente el servicio de Mascota en este controlador
    private mascotaService mascotaService;

    @GetMapping // Mapeamos la solicitud GET a /api/v1/mascotas para listar todas las mascotas
    public List<mascota> listarTodas() {
        return mascotaService.listarTodas();
    }
    
    // Mapeamos la solicitud GET a /api/v1/mascotas/{id} para obtener una mascota por ID
    @GetMapping("/{id}")
    public ResponseEntity<mascota> obtenerPorId(@PathVariable Long id) {
        return mascotaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Mapeamos la solicitud POST a /api/v1/mascotas para crear una nueva mascota
    @PostMapping
    public mascota crear(@RequestBody mascota mascota) {
        return mascotaService.guardar(mascota);
    }

    // Mapeamos la solicitud PUT a /api/v1/mascotas/{id} para actualizar una mascota existente
    @PutMapping("/{id}")
    public ResponseEntity<mascota> actualizar(@PathVariable Long id, @RequestBody mascota mascota) {
        mascota actualizada = mascotaService.actualizar(id, mascota);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Mapeamos la solicitud DELETE a /api/v1/mascotas/{id} para eliminar una mascota por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
