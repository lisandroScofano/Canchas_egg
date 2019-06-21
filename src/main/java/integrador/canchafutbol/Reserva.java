/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.canchafutbol;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Lisandro
 */
@Entity
public class Reserva {

    @Id
    private String idreserva;

   
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReserva;
    
    @ManyToOne
    private Equipo equipo1;

    @ManyToOne
    private Equipo equipo2;
    
    @ManyToOne
    private Cancha cancha; 

    public Reserva() {
        idreserva = UUID.randomUUID().toString();
    }

    public Reserva(String idreserva, Date dReserva, Equipo dequipo1, Equipo dequipo2) {
        idreserva = UUID.randomUUID().toString();
//        this.fechaReserva = dReserva;
//        this.equipo1 = dequipo1;
//        this.equipo2 = dequipo2;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }
    public String getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(String idreserva) {
        this.idreserva = idreserva;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }


    public boolean realizarReserva(Date fecha, Cancha cancha, Equipo e1, Equipo e2) {
        if (!hayJugadoresRepetidos(e1, e2)) {
            Reserva nueva = new Reserva();
            nueva.setFechaReserva(fecha);
            nueva.setEquipo1(e1);
            nueva.setEquipo2(e2);
            cancha.addReserva(nueva);
            this.setCancha(cancha);
            return true;
        } else {
            return false;
        }
    }

    private boolean hayJugadoresRepetidos(Equipo e1, Equipo e2) {
        for (Persona o1 : e1.getJugador()) {
            for (Persona o2 : e2.getJugador()) {
                if (o1.getNombre().equals(o2.getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idreserva=" + idreserva + ", fechaReserva=" + fechaReserva + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", cancha=" + cancha + '}';
    }



    
}
