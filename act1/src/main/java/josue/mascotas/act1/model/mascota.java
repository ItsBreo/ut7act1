package josue.mascotas.act1.model;

import jakarta.persistence.*;


@Entity // Indica que esta clase es una entidad que se mapeará a una tabla de base de datos
public class mascota {
    @Id // Marca como el atributo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor se autoincrementa
    private long id;
    private String nombre;
    private String especie;
    private int edad;
    private boolean adoptado;

    
     // Constructor vacío (por defecto)
     public mascota() {
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
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


    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }


    public boolean isAdoptado() {
        return adoptado;
    }


    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }


    @Override
    public String toString() {
        return "mascota [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", adoptado="
                + adoptado + "]";
    }

    
}
