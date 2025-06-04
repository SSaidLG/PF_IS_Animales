package unam.fesaragon.ico.is.proyectofinal.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "animales")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "especie", nullable = false, length = 50)
    private String especie;

    @Column(name = "url_foto",
            nullable = true,
            insertable = false,
            columnDefinition = "VARCHAR(250) DEFAULT 'https://ciep.mx/wp-content/uploads/2019/09/placeholder.png'"
    )
    private String foto;

    @Column(name = "edad", nullable = true)
    private int edad;

    public Animal() {}

    public Animal(int id, String nombre, String especie, String foto, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.foto = foto;
        this.edad = edad;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // equals, hashCode, toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return id == animal.id && edad == animal.edad &&
                Objects.equals(nombre, animal.nombre) &&
                Objects.equals(especie, animal.especie) &&
                Objects.equals(foto, animal.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, especie, foto, edad);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", foto='" + foto + '\'' +
                ", edad=" + edad +
                '}';
    }
}