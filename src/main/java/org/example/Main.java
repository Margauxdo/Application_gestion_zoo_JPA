package org.example;

import org.example.DAO.AnimalDAO;
import org.example.Entity.Animal;
import org.example.Entity.Diet;
import org.example.Util.IHM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zoo");
        EntityManager em = emf.createEntityManager();

        AnimalDAO animalDAO = new AnimalDAO(em);
        Animal animal = Animal.builder()
                .species("singe")
                .name("Louis")
                .age(12)
                .diet(Diet.VEGAN)
                .date(LocalDate.parse("2012-05-20"))
                .build();



        new IHM(em).start();

        em.close();
        emf.close();

    }
}

