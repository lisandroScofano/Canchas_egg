package integrador.canchafutbol.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/Integrador-0.0.1-SNAPSHOT/")
public class ControladorInicio {
    public ModelAndView listado() {
        ModelAndView modelo = new ModelAndView();

        modelo.setViewName("index.html");

        return modelo;
    }

}
