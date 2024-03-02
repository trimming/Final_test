package model;

import java.util.Date;

public class MakerNewEntries {
    public Animal makeNewEntryAboutAnimal(int id, String name, Date dateOfBirth, String commands, String kindOfAnimal, String typeAnimal) {
        Animal animal = switch (typeAnimal) {
            case "Cat" -> new Cat();
            case "Dog" -> new Dog();
            case "Hamster" -> new Hamster();
            case "Horse" -> new Horse();
            case "Camel" -> new Camel();
            case "Donkey" -> new Donkey();
            default -> throw new IllegalStateException("Unexpected value: " + typeAnimal);
        };
        animal.setAnimalId(id);
        animal.setName(name);
        animal.setDateOfBirth(dateOfBirth);
        animal.setCommands(commands);
        animal.setKindOfAnimal(kindOfAnimal);
        animal.setTypeAnimal(typeAnimal);
        return animal;
    }
}
