/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.canchafutbol;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Lisandro
 */
@Entity
public class Persona {

    @Id
    private Integer dni;
    private String nombre;
    private String apellido;

    @Transient
    private Random r = new Random();

    @Transient
    private String[] nombres = {"Mario", "Claudio", "Jose", "Alberto", "Ricardo", "Emiliano", "Lisandro", "Oscar", "Gustavo", "Juan", "Mariano", "Uriel", "Lucas", "Blas", "Sebastian", "Agustin", "Jony", "Javier", "Matias"};
    @Transient
    private String[] apellidos = {"Scofano", "Caviglia", "Garcia", "Perez", "Muñoz", "Civit", "Peña", "Reta", "Calabria", "Alberti", "Navarro", "Tinelli", "Darin", "Francella", "Ricardi", "Rosin", "Etchevere", "Olmedo", "Gutierrez"};

    public Persona() {
        this.nombre = nombres[r.nextInt(nombres.length)];
        this.apellido = apellidos[r.nextInt(nombres.length)];
        this.dni = r.nextInt(10000000) + 30000000;
    }

    public Persona(Integer dni) {
        this.nombre = nombres[r.nextInt(nombres.length)];
        this.apellido = apellidos[r.nextInt(nombres.length)];

    }

    public Persona(String nombre, String apellido, Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", r=" + r + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }

}
