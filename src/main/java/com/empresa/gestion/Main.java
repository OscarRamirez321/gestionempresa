package com.empresa.gestion;

import com.empresa.gestion.model.Cargo;
import com.empresa.gestion.model.Empleado;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();


        em.getTransaction().begin();

        Cargo cargoDev = new Cargo();
        cargoDev.setNombre("Desarrollador de Software");
        cargoDev.setDescripcion("Escribe código para aplicaciones increíbles.");
        em.persist(cargoDev); // Guardar el cargo en la BD

        em.getTransaction().commit();
        System.out.println("Cargo 'Desarrollador' guardado con éxito.");

        // --- PASO 2: Crear un Empleado y asignarle el Cargo ---
        em.getTransaction().begin();

        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Ana");
        empleado1.setApellido("López");
        empleado1.setCargo(cargoDev);
        em.persist(empleado1);

        em.getTransaction().commit();
        System.out.println("Empleado 'Ana' guardado y asignado al cargo.");


        em.close();
        JPAUtil.close();
    }
}