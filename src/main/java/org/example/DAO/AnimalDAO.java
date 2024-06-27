package org.example.DAO;


import org.example.Entity.Diet;
import org.example.Entity.Animal;
import org.example.Entity.Diet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.example.Entity.Diet.CARNIVORE;
import static org.example.Entity.Diet.VEGAN;

public class AnimalDAO {

    private EntityManager em;

    public AnimalDAO(EntityManager em) {
        this.em = em;
    }

    public void createAnimal(Animal animal) {
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();


    }
    public void searchID(int id){
        Query query = em.createQuery("select a from Animal a where id = :id ", Animal.class);
        query.setParameter("id",id);
        List<Animal> animalList = query.getResultList();

        System.out.println(animalList);
        Animal animal1 = em.find(Animal.class,1);
        try{
            Animal animal2 = em.getReference(Animal.class,2);
            System.out.println(animal2);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(id);


    }
    public void searchName(String name){
        Query query = em.createQuery("select a from Animal a where name = :name", Animal.class);
        query.setParameter("name",name);
        List<Animal> animalList = query.getResultList();
        System.out.println(animalList);

    }

    public void searchDiet(Diet diet){
        Query query = em.createQuery("select a from Animal a where diet = :diet", Animal.class);
        query.setParameter("diet",diet);
        List<Animal> animalList = query.getResultList();
        System.out.println(animalList);


        System.out.println(diet);
    }



}


