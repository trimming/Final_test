package controller;

import model.Animal;
import service.AnimalService;
import service.Counter;

import java.sql.*;
import java.util.ArrayList;

public class AnimalController implements Controller{
    private final AnimalService animalService = new AnimalService();

    ArrayList<Animal> animalArrayList;
    public AnimalController() {

    }

    public void printAllAnimals(){
        animalArrayList = getAnimalList();
        for (Animal animal : animalArrayList) {
            String j = String.valueOf(animal);
            System.out.println(j);
        }
    }

    public ArrayList<Animal> getAnimalList(){
        return animalService.getAllAnimals();
    }

    @Override
    public void create() {
        animalService.create();
    }
}
