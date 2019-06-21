package integrador.canchafutbol.controladores;

import integrador.canchafutbol.Persona;
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
@RequestMapping("/personas")
public class ControladorPersona {

    @GetMapping("/")
    public ModelAndView raiz() {
        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("persona-listado.html");
        return modelo;
    }
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/listado")
    public ModelAndView listado() {
        ModelAndView modelo = new ModelAndView();

        List<Persona> p = personaRepository.findAll();

        modelo.addObject("personas", p);
        modelo.setViewName("persona-listado.html");

        return modelo;
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Integer dni) {

        if (dni != null) {
            Persona persona = personaRepository.findById(dni).get();
            if (persona != null) {
                personaRepository.delete(persona);
            }
        }

        return "redirect:/personas/listado";
    }

    @GetMapping("/inicio")
    public ModelAndView inicio(@RequestParam(required = false) Integer dni) {

        Persona persona = new Persona();
        if (dni != null) {
            persona = personaRepository.findById(dni).get();
        }

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("persona-formulario.html");
        modelo.addObject("persona", persona);
        return modelo;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute("persona") Persona persona) {
        System.out.println("Persona: " + persona.toString());

        personaRepository.save(persona);

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("persona-formulario.html");
        modelo.addObject("persona", new Persona());
        modelo.addObject("mensaje", "La persona se guardo correctamente.");

        return modelo;
    }

}
