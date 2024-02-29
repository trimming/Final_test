import menu.UserMenu;
import model.Animal;
import model.Dog;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserMenu menu = new UserMenu();
        menu.start();
        menu.getAllAnimals();



    }
}
