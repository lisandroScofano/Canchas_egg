package integrador.canchafutbol.controladores;

import integrador.canchafutbol.Cancha;
import integrador.canchafutbol.repository.CanchaRepository;
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
@RequestMapping("/canchas")
public class ControladorCancha {

    @GetMapping("/")
    public ModelAndView raiz() {
        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("cancha-listado.html");
        return modelo;
    }

    @Autowired
    private CanchaRepository canchaRepository;

    @GetMapping("/listado")
    public ModelAndView listado() {
        ModelAndView modelo = new ModelAndView();

        List<Cancha> canchas = canchaRepository.findAll();

        modelo.addObject("canchas", canchas);
        modelo.setViewName("cancha-listado.html");

        return modelo;
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String idcancha) {

        if (idcancha != null) {
            Cancha cancha = canchaRepository.findById(idcancha).get();
            canchaRepository.delete(cancha);
        }

        return "redirect:/canchas/listado";
    }

    @GetMapping("/inicio")
    public ModelAndView inicio(@RequestParam(required = false) String idcancha) {

        Cancha cancha = new Cancha();
        if (idcancha != null) {
            cancha = canchaRepository.findById(idcancha).get();
        }

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("cancha-formulario.html");
        modelo.addObject("cancha", cancha);
        return modelo;
    }

    @PostMapping("/guardar")
    public ModelAndView guardar(@ModelAttribute("cancha") Cancha cancha) {
        System.out.println("Cancha: " + cancha.toString());

        canchaRepository.save(cancha);

        ModelAndView modelo = new ModelAndView();
        modelo.setViewName("cancha-formulario.html");
        modelo.addObject("cancha", new Cancha());
        modelo.addObject("mensaje", "La cancha se guardo correctamente.");

        return modelo;
    }

}
