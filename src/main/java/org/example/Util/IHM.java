


package org.example.Util;

import org.example.DAO.AnimalDAO;
import org.example.Entity.Animal;
import org.example.Entity.Diet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Scanner;

public class IHM {

    private static AnimalDAO animalDAO;
    private static Scanner scanner;


    public IHM(EntityManager em){
        animalDAO =new AnimalDAO(em);
        scanner = new Scanner(System.in);

    }
    public  void start (){
        String entry;
        while (true){
            System.out.println(" ---- student Menu -----");
            System.out.println("1/ create animal");
            System.out.println("2/ search by id");
            System.out.println("3/ search by name");
            System.out.println("4/ search by diet");
            entry = scanner.nextLine();
            switch (entry){
                case "1"->createAnimal();
                case "2"->searchID();
                case "3"->searchName();
                case "4"-> searchDiet();
                default -> {
                    return;
                }
            }
        }
    }

    private void createAnimal(){
        System.out.println("Please enter the species name");
        String species = scanner.nextLine();
        System.out.println("Please enter the name of the animal");
        String name = scanner.nextLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter his diet");
        Diet diet = Diet.valueOf(scanner.nextLine());
        System.out.println("Please enter his entry date");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        Animal animal = Animal.builder()
                .species(species)
                .name(name)
                .age(age)
                .diet(diet)
                .date(date)
                .build();
        animalDAO.createAnimal(animal);
        System.out.println("Animal created successfully !");

    }
    private void searchID(){

        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        animalDAO.searchID(id);
    }
    private void searchName(){
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        animalDAO.searchName(name);


    }
    private void searchDiet(){
        System.out.println("Enter the diet");
        Diet diet = Diet.valueOf(scanner.nextLine());
        animalDAO.searchDiet(diet);

    }

}