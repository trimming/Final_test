package controller;

import service.AnimalService;

import java.sql.*;

public class AnimalController implements Controller{
    private final AnimalService animalService = new AnimalService();
    public AnimalController() {
    }

    public void printAllAnimals(){
        animalService.getAllAnimals();
    }

    @Override
    public void create() {
        animalService.create();
    }
}
