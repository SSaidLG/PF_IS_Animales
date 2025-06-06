package unam.fesaragon.ico.is.proyectofinal.controllers;

import unam.fesaragon.ico.is.proyectofinal.entities.Animal;
import unam.fesaragon.ico.is.proyectofinal.service.interfaces.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/animales")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Animal>> getAnimales() {
        return ResponseEntity.ok(animalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        Optional<Animal> animal = animalService.buscarPorId(id);
        return animal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) throws URISyntaxException {
        Animal creado = animalService.crear(animal);
        return ResponseEntity
                .created(new URI("/api/v1/animales/" + creado.getId()))
                .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        Animal actualizado = animalService.actualizar(id, animal);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        Animal eliminado = animalService.eliminar(id);
        if (eliminado != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}