package pe.edu.tecsup.laboratoio12springbootthymeleaf.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "edad")
    private int edad;

    @Column(name = "sexo", length = 1)
    private String sexo;

    public Estudiante() {}

    public Estudiante(int id, String nombres, String apellidos, int edad, String sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(final String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(final int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }
}
