package menu;

import controller.AnimalController;
import model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    AnimalController animalController;
    ArrayList<Animal> animalArrayList;
    public UserMenu() {
        this.animalController = new AnimalController();
        this.animalArrayList = animalController.getAnimalList();
    }
    public void start() {
        System.out.println("Приветствую Вас в нашем питомнике!");
        try(Scanner scanner = new Scanner(System.in)) {
            boolean flag = true;
            while(flag) {
                System.out.println(
                        """

                                Все обитатели питомника - 1;\s
                                Завести новое животное - 2;\s
                                Список команд животного - 3;\s
                                Добавить команду - 4;
                                Выйти - 0.""");
                String value = scanner.next();
                switch (value) {
                    case "1":
                        animalController.printAllAnimals();
                        break;
                    case "2":
                        animalController.create();
                        break;
                    case "3":

                        break;
                    case "4":
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Не верная команда!");
                        break;
                }

            }
        }
    }

}
