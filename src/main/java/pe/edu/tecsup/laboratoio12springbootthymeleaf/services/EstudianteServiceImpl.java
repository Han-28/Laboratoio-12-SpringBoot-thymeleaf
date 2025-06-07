package pe.edu.tecsup.laboratoio12springbootthymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.entities.Estudiante;
import pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.persistence.EstudianteDAO;

import java.util.List;
@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    private EstudianteDAO dao;

    @Override
    @Transactional(readOnly = false)
    public void grabar(Estudiante estudiante) {
        dao.save(estudiante);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public Estudiante buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listar() {
        return (List<Estudiante>)dao.findAll();
    }
}
