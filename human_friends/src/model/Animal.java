package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public abstract class Animal {
    private int animalId;
    private String name;
    private Date dateOfBirth;
    private ArrayList<String> commands;
    private String kindOfAnimal;
    private String typeAnimal;

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = (ArrayList<String>) Arrays.asList(commands.split("\\s*,\\s*"));
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
