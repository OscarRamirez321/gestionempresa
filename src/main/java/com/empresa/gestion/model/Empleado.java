package com.empresa.gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter @Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    @ManyToOne // Muchos empleados pueden tener un cargo
    @JoinColumn(name = "cargo_id") // La columna que los une
    private Cargo cargo;

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + " " + apellido + ", cargo=" + cargo.getNombre() + "]";
    }
}