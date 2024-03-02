package service;

import model.Animal;

import java.util.ArrayList;

public interface Service {
    ArrayList<Animal> getAllAnimals();
    void create();
}
