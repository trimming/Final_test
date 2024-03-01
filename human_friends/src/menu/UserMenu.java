package menu;

import controller.AnimalController;

import java.sql.*;
import java.util.Scanner;

public class UserMenu {
    AnimalController animalController;
    public UserMenu(AnimalController controller) {
        this.animalController = controller;
    }
    public void start() {
        System.out.println("Приветствую Вас в нашем питомнике!");
        try(Scanner scanner = new Scanner(System.in)) {
            boolean flag = true;
            while(flag) {
                System.out.println(
                        "\nВсе обитатели питомника - 1; " +
                                "\nЗавести новое животное - 2; " +
                                "\nСписок команд животного - 3; " +
                                "\nДобавить команду - 4;" +
                                "\nВыйти - 0.");
                String value = scanner.next();
                switch (value) {
                    case "1":
                        animalController.printAllAnimals();
                        break;
                    case "2":
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
