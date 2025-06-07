package pe.edu.tecsup.laboratoio12springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.entities.Estudiante;
import pe.edu.tecsup.laboratoio12springbootthymeleaf.services.EstudianteService;

import java.util.Map;

@Controller
public class EstudianteController {
    @Autowired
    private EstudianteService servicio;

    @RequestMapping("/")
    public String inicio() {
        return "redirect:/estudiante/listar";
    }

    // Listar a los estudiantes
    @RequestMapping(value = "/estudiante/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Estudiantes");
        model.addAttribute("estudiantes", servicio.listar());
        return "estudiante/listEstudiante"; // Vista Thymeleaf
    }

    // Crear nuevo estudiante
    @RequestMapping(value = "/estudiante/form")
    public String crear(Map<String, Object> model) {
        Estudiante estudiante = new Estudiante();
        model.put("estudiante", estudiante);
        model.put("titulo", "Formulario de Estudiante");
        return "estudiante/formEstudiante"; // Vista Thymeleaf
    }

    // Editar estudiante
    @RequestMapping(value = "/estudiante/editar/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Estudiante estudiante = null;

        if (id > 0) {
            estudiante = servicio.buscar(id);
        } else {
            return "redirect:/estudiante/listar";
        }

        model.put("estudiante", estudiante);
        model.put("titulo", "Editar Estudiante");
        return "estudiante/editEstudiante"; // Vista Thymeleaf
    }

    // Guardar estudiante
    @RequestMapping(value = "/estudiante/form", method = RequestMethod.POST)
    public String guardar(@Validated Estudiante estudiante, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Estudiante");
            return "estudiante/formEstudiante"; // Vista Thymeleaf
        }

        servicio.grabar(estudiante);
        status.setComplete();
        return "redirect:/estudiante/listar";
    }

    // Ver detalles del estudiante
    @RequestMapping(value = "/estudiante/ver/{id}", method = RequestMethod.GET)
    public String ver(@PathVariable("id") Integer id, Model model) {
        Estudiante estudiante = servicio.buscar(id);
        if (estudiante == null) {
            return "redirect:/estudiante/listar";
        }
        model.addAttribute("estudiante", estudiante);
        return "estudiante/verEstudiante"; // Vista Thymeleaf
    }

    // Eliminar estudiante
    @RequestMapping(value = "/estudiante/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            servicio.eliminar(id);
        }
        return "redirect:/estudiante/listar";
    }



}
