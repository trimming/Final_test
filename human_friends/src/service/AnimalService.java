package service;

import model.Animal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalService implements Service{
    @Override
    public void getAllAnimals() {
        List<Animal> animalList = new ArrayList<Animal>();
        Animal animal;
        try{
            String url = "jdbc:mysql://localhost/humananimals";
            String username = "root";
            String password = "12345";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM All_animals");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Date dateOfBirth = resultSet.getDate(3);
                    String commands = resultSet.getString(4);
                    String kindOfAnimal = resultSet.getString(5);
                    String typeAnimal = resultSet.getString(6);
                    System.out.printf("%1$d. %2$s - %3$tY-%3$tm-%3$td '%4$s' %5$s %6$s\n", id, name,
                            dateOfBirth, commands, kindOfAnimal, typeAnimal);



                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    @Override
    public void create() {
        try{
            String url = "jdbc:mysql://localhost/humananimals";
            String username = "root";
            String password = "12345";
            Scanner scanner = new Scanner(System.in);

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.print("Введите имя животного: ");
            String name = scanner.nextLine();

            System.out.print("Введите дату рождения животного в фомате ГГГГ-ММ-ДД: ");
            String dateOfBirth = scanner.nextLine();

            System.out.print("Введите через запятую команды, которые выполняет животное: ");
            String commands = scanner.nextLine();

            System.out.print("Введите тип животного: " +
                    "\nЕсли это кошка - 1;" +
                    "\nСобака - 2;" +
                    "\nХомяк - 3;" +
                    "\nЛошадь - 4;" +
                    "\nВерблюд - 5;" +
                    "\nОсел - 6.\n");
            String type_animal = null;
            String kindOfAnimal = null;
            switch (scanner.nextLine()) {
                case "1":
                    type_animal = "Cat";
                     kindOfAnimal = "Pet";
                    break;
                case "2":
                    type_animal = "Dog";
                    kindOfAnimal = "Pet";
                    break;
                case "3":
                    type_animal = "Hamster";
                    kindOfAnimal = "Pet";
                    break;
                case "4":
                    type_animal = "Horse";
                    kindOfAnimal = "Pack_animals";
                    break;
                case "5":
                    type_animal = "Camel";
                    kindOfAnimal = "Pack_animals";
                    break;
                case "6":
                    type_animal = "Donkey";
                    kindOfAnimal = "Pack_animals";
                    break;
                default:
                    System.out.println("Этих не принимаем!");
                    break;
            };

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO All_animals (name, date_of_birth, commands, class, type_animal) Values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, dateOfBirth);
                preparedStatement.setString(3, commands);
                preparedStatement.setString(4, kindOfAnimal);
                preparedStatement.setString(5, type_animal);

                int rows = preparedStatement.executeUpdate();

                System.out.printf("%d rows added", rows);
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
