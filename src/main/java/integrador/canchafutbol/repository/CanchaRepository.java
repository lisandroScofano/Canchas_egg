package integrador.canchafutbol.repository;

import integrador.canchafutbol.Cancha;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository("canchaRepository")
public interface CanchaRepository extends JpaRepository<Cancha, String>{
    @Query("SELECT c FROM Cancha c ORDER BY c.nombre")
    public List<Cancha> bucarPorNombre();
    
}
