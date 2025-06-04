package unam.fesaragon.ico.is.proyectofinal.controllers;

import unam.fesaragon.ico.is.proyectofinal.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unam.fesaragon.ico.is.proyectofinal.service.interfaces.AnimalService;

import java.net.URI;
import java.net.URISyntaxException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/animales")
public class RestController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Animal>> getAnimales() {
        return new ResponseEntity<>(animalService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) throws URISyntaxException {
        return ResponseEntity.created(new URI("http://localhost:8080/")).body(animalService.crear(animal));
    }
}