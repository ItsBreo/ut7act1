package josue.mascotas.act1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import josue.mascotas.act1.model.mascota;
import josue.mascotas.act1.service.mascotaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mascotas")
public class mascotaController {
    @Autowired
    private mascotaService mascotaService;

    @GetMapping
    public List<mascota> listarTodas() {
        return mascotaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<mascota> obtenerPorId(@PathVariable Long id) {
        return mascotaService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public mascota crear(@RequestBody mascota mascota) {
        return mascotaService.guardar(mascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<mascota> actualizar(@PathVariable Long id, @RequestBody mascota mascota) {
        mascota actualizada = mascotaService.actualizar(id, mascota);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
