/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.canchafutbol;

import integrador.canchafutbol.Reserva;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Lisandro
 */
@Entity
public class Cancha {

    @Id
    private String idcancha;
    private String nombre;
    
    @OneToMany
    private List<Reserva> reservas = new ArrayList<>();

    public Cancha() {
        this.idcancha = UUID.randomUUID().toString();
    }

    public Cancha(String id, String name) {
        this.idcancha = UUID.randomUUID().toString();
        this.nombre = name;
    }

    public void addReserva(Reserva nueva) {
        reservas.add(nueva);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }



    public String getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(String idcancha) {
        this.idcancha = idcancha;
    }

    @Override
    public String toString() {
        return "Cancha{" + "idcancha=" + idcancha + ", nombre=" + nombre + ", reservas=" + reservas + '}';
    }

    
}
