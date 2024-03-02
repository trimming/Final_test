package controller;

import model.Animal;
import service.AnimalService;
import service.Counter;

import java.sql.*;
import java.util.ArrayList;

public class AnimalController implements Controller{
    private final AnimalService animalService = new AnimalService();
    public Counter counter = new Counter();
    ArrayList<Animal> animalArrayList;
    public AnimalController() {
        this.animalArrayList = getAnimalList();
    }

    public void printAllAnimals(){
        for (Animal animal : animalArrayList) {
            String j = String.valueOf(animal);
            System.out.println(j);
        }
    }

    public ArrayList<Animal> getAnimalList(){
        return animalService.getAllAnimals();
    }

    public void getAnimalId(){
        counter.getEntryId();
    }

    @Override
    public void create() {
        animalService.create();
    }
}
