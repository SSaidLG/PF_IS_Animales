package unam.fesaragon.ico.is.proyectofinal.mappers;

import unam.fesaragon.ico.is.proyectofinal.dto.AnimalUpdateDto;
import unam.fesaragon.ico.is.proyectofinal.entities.Animal;

public class AnimalMapper {
    public static void actualizarEntidad(Animal animal, AnimalUpdateDto dto) {
        if (dto.getNombre() != null) animal.setNombre(dto.getNombre());
        if (dto.getEspecie() != null) animal.setEspecie(dto.getEspecie());
        if (dto.getFoto() != null) animal.setFoto(dto.getFoto());
        if (dto.getEdad() != null) animal.setEdad(dto.getEdad());
    }
}