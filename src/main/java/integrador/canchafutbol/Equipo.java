/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.canchafutbol;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 *
 * @author Lisandro
 */
@Entity
public class Equipo {

    @Id
    private String idequipo;
    private String nombre;

    @ManyToMany
    private List<Persona> jugadores = new ArrayList<>();
    private int max_jugadores = 11;

    
    @Transient
    private List<Integer> seleccionados = new ArrayList<>();
    
    
    public Equipo(String idequipo, String name, int jugadores) {
        this.idequipo = UUID.randomUUID().toString();
        this.nombre = name;
        this.max_jugadores = jugadores;
    }

    public Equipo() {
        this.idequipo = UUID.randomUUID().toString();

    }

    public void addJugador(Persona jugador) {
        if (this.jugadores.size() <= max_jugadores) {
            this.jugadores.add(jugador);
        } else {
            System.out.println("El equipo esta completo");
        }
    }

    public List<Persona> getJugador() {
        return this.jugadores;
    }

    public String getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(String idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMax_jugadores() {
        return max_jugadores;
    }

    public void setMax_jugadores(int max_jugadores) {
        this.max_jugadores = max_jugadores;
    }

   

    public void setJugadores(List<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Integer> getSeleccionados() {
        return seleccionados;
    }

    public void setSeleccionados(List<Integer> seleccionados) {
        this.seleccionados = seleccionados;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idequipo=" + idequipo + ", nombre=" + nombre + ", jugadores=" + jugadores + ", max_jugadores=" + max_jugadores + ", seleccionados=" + seleccionados + '}';
    }




    
}
