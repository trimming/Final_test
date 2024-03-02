package service;

import model.Animal;
import model.MakerNewEntries;

import java.sql.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalService implements Service{
    MakerNewEntries makerNewEntries;
    Counter counter;

    public AnimalService() {
        this.makerNewEntries = new MakerNewEntries();
        this.counter = new Counter();
    }

    @Override
    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animalList = new ArrayList<>();
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

                    animal = makerNewEntries.makeNewEntryAboutAnimal(id, name, dateOfBirth, commands, kindOfAnimal, typeAnimal);
                    animalList.add(animal);
                }
                return animalList;
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return animalList;
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

            System.out.print("""
                    Введите тип животного:\s
                    Если это кошка - 1;
                    Собака - 2;
                    Хомяк - 3;
                    Лошадь - 4;
                    Верблюд - 5;
                    Осел - 6.
                    """);
            String type_animal = null;
            String kindOfAnimal = null;
            switch (scanner.nextLine()) {
                case "1" -> {
                    type_animal = "Cat";
                    kindOfAnimal = "Pet";
                }
                case "2" -> {
                    type_animal = "Dog";
                    kindOfAnimal = "Pet";
                }
                case "3" -> {
                    type_animal = "Hamster";
                    kindOfAnimal = "Pet";
                }
                case "4" -> {
                    type_animal = "Horse";
                    kindOfAnimal = "Pack_animals";
                }
                case "5" -> {
                    type_animal = "Camel";
                    kindOfAnimal = "Pack_animals";
                }
                case "6" -> {
                    type_animal = "Donkey";
                    kindOfAnimal = "Pack_animals";
                }
                default -> System.out.println("Этих не принимаем!");
            }
            ;

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
