package unam.fesaragon.ico.is.proyectofinal.dto;

public class AnimalUpdateDto {
    private String nombre;
    private String especie;
    private String foto;
    private Integer edad;

    public AnimalUpdateDto() {}

    public AnimalUpdateDto(String nombre, String especie, String foto, Integer edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.foto = foto;
        this.edad = edad;
    }

    // Getters y Setters

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}