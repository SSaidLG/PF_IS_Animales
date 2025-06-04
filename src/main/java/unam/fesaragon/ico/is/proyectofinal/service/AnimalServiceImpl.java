package unam.fesaragon.ico.is.proyectofinal.service;

import unam.fesaragon.ico.is.proyectofinal.entities.Animal;
import unam.fesaragon.ico.is.proyectofinal.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unam.fesaragon.ico.is.proyectofinal.service.interfaces.AnimalService;

import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal crear(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Iterable<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> buscarPorId(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal actualizar(Long id, Animal animal) {
        Optional<Animal> actual = animalRepository.findById(id);
        if (actual.isPresent()) {
            Animal tmp = actual.get();
            tmp.setNombre(animal.getNombre());
            tmp.setEspecie(animal.getEspecie());
            tmp.setFoto(animal.getFoto());
            tmp.setEdad(animal.getEdad());
            return animalRepository.save(tmp);
        } else {
            return null;
        }
    }

    @Override
    public Animal eliminar(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isPresent()) {
            animalRepository.deleteById(id);
            return animal.get();
        } else {
            return null;
        }
    }
}