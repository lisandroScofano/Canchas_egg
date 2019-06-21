/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.canchafutbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import integrador.canchafutbol.Reserva;

/**
 *
 * @author mora
 */
@Repository("reservaRepository")
public interface ReservaRepository extends JpaRepository<Reserva, String>{
    
}
