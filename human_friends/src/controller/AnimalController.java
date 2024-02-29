package controller;

import java.sql.*;

public class AnimalController {
    public AnimalController() {
    }

    public void getAllAnimals(){
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
                    System.out.printf("%1$d. %2$s - %3$tm-%3$td-%3$td '%4$s' %5$s %6$s\n", id, name,
                            dateOfBirth, commands, kindOfAnimal, typeAnimal);
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
