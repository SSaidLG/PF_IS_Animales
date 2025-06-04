package unam.fesaragon.ico.is.proyectofinal.repositories;

import unam.fesaragon.ico.is.proyectofinal.entities.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    //public Animal findAnimalById(Long id);
    //public Animal deleteById(Long id);
}
