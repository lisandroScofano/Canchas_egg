package integrador.canchafutbol.repository;


import integrador.canchafutbol.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("equipoRepository")
public interface EquipoRepository extends JpaRepository<Equipo, String>{

    
}
