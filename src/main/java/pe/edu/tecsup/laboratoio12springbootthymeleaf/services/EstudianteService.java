package pe.edu.tecsup.laboratoio12springbootthymeleaf.services;

import pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.entities.Estudiante;

import java.util.List;

public interface EstudianteService {
    public List<Estudiante> listar();

    public void grabar(Estudiante estudiante);

    public Estudiante buscar(Integer id);

    public void eliminar(Integer id);
}
