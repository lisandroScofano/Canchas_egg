package integrador.canchafutbol.controladores;

import integrador.canchafutbol.Equipo;
import integrador.canchafutbol.Persona;
import integrador.canchafutbol.repository.EquipoRepository;
import integrador.canchafutbol.repository.PersonaRepository;
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
@RequestMapping("/equipos")
public class ControladorEquipo {

    @GetMapping("/")
    public ModelAndView raiz() {
        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("equipo-listado.html");
        return modelo;
    }
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/listado")
    public ModelAndView listado() {
        ModelAndView modelo = new ModelAndView();

        List<Equipo> equipos = equipoRepository.findAll();

        modelo.addObject("equipos", equipos);
        modelo.setViewName("equipo-listado.html");

        return modelo;
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String idequipo) {

        if (idequipo != null) {
            Equipo equipo = equipoRepository.findById(idequipo).get();
            equipoRepository.delete(equipo);
        }

        return "redirect:/equipos/listado";
    }

    @GetMapping("/inicio")
    public ModelAndView inicio(@RequestParam(required = false) String idequipo) {

        Equipo equipo = new Equipo();
        if (idequipo != null) {
            equipo = equipoRepository.findById(idequipo).get();
        }

        List<Persona> personas = personaRepository.findAll();
        List<Persona> jugadores = equipo.getJugador();

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("equipo-formulario.html");
        modelo.addObject("equipo", equipo);
        System.out.println("equipo : " + equipo);
        modelo.addObject("personas", personas);
        System.out.println("personas: " + personas);
        modelo.addObject("jugadores", jugadores);
        System.out.println("jugadores:" + jugadores);
        return modelo;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute("equipo") Equipo equipo) {
        System.out.println("Equipo: " + equipo.toString());

        for (Integer dni : equipo.getSeleccionados()) {
            Persona persona = personaRepository.findById(dni).get();
            System.out.println("persona.nombre");
            equipo.addJugador(persona);
        }
        List<Persona> personas = personaRepository.findAll();
        List<Persona> jugadores = equipo.getJugador();
        equipoRepository.save(equipo);
        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("equipo-formulario.html");
        modelo.addObject("personas", personas);
        modelo.addObject("equipo", equipo);
        modelo.addObject("jugadores", jugadores);
        modelo.addObject("mensaje", "El equipo se guardo correctamente.");

        return modelo;
    }

}
