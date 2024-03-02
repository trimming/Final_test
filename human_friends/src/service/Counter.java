package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Counter {
    int count;

    public Counter() {

    }

    public int add() {
        count = getEntryId();
        return count++;
    }
    public int getEntryId() {
        int id = 0;
        try{
            String url = "jdbc:mysql://localhost/humananimals";
            String username = "root";
            String password = "12345";
            Scanner scanner = new Scanner(System.in);

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM All_animals");
                while(resultSet.next()){

                    id = resultSet.getInt(1);

                }
                return id;
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return id;
    }
}
