package unam.fesaragon.ico.is.proyectofinal.service.interfaces;

import unam.fesaragon.ico.is.proyectofinal.entities.Animal;

import java.util.Optional;

public interface AnimalService {
    Animal crear(Animal animal);
    Iterable<Animal> listarTodos();
    Optional<Animal> buscarPorId(Long id);
    Animal actualizar(Long id, Animal animal);
    Animal eliminar(Long id);
}