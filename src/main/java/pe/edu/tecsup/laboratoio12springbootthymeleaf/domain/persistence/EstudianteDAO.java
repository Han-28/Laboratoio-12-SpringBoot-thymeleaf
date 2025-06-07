package pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.entities.Estudiante;

public interface EstudianteDAO extends JpaRepository<Estudiante, Integer> {
}
