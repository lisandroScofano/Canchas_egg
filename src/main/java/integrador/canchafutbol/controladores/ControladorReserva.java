package integrador.canchafutbol.controladores;

import integrador.canchafutbol.Cancha;
import integrador.canchafutbol.Equipo;
import integrador.canchafutbol.Reserva;
import integrador.canchafutbol.repository.CanchaRepository;
import integrador.canchafutbol.repository.EquipoRepository;
import integrador.canchafutbol.repository.ReservaRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reservas")
public class ControladorReserva {

    @GetMapping("/")
    public ModelAndView raiz() {
        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("reserva-listado.html");
        return modelo;
    }

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private CanchaRepository canchaRepository;

    @GetMapping("/listado")
    public ModelAndView listado() {
        ModelAndView modelo = new ModelAndView();

        List<Reserva> r = reservaRepository.findAll();

        modelo.addObject("reservas", r);
        modelo.setViewName("reserva-listado.html");

        return modelo;
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String idreserva) {

        if (idreserva != null) {
            Reserva reserva = reservaRepository.findById(idreserva).get();
            if (reserva != null) {
                reservaRepository.delete(reserva);
            }
        }

        return "redirect:/reservas/listado";
    }

    @GetMapping("/inicio")
    public ModelAndView inicio(@RequestParam(required = false) String id) {

        Reserva reserva = new Reserva();
        if (id != null) {
            reserva = reservaRepository.findById(id).get();
        }
        List<Equipo> equipos = new ArrayList<>();
        equipos = equipoRepository.findAll();

        List<Cancha> canchas = new ArrayList<>();
        canchas = canchaRepository.findAll();

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("reserva-formulario.html");
        modelo.addObject("reserva", reserva);
        modelo.addObject("equipos", equipos);
        modelo.addObject("canchas", canchas);
        return modelo;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute("reserva") Reserva reserva) {
        System.out.println("Reserva: " + reserva.toString());

        reservaRepository.save(reserva);

        List<Equipo> equipos = new ArrayList<>();
        equipos = equipoRepository.findAll();

        List<Cancha> canchas = new ArrayList<>();
        canchas = canchaRepository.findAll();

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("reserva-formulario.html");
        Reserva reserva2 = new Reserva();
        modelo.addObject("reserva", reserva2);
        modelo.addObject("equipos", equipos);
        modelo.addObject("canchas", canchas);

        modelo.addObject("mensaje", "La reserva se guardo correctamente.");
        return modelo;
    }
}
