package edu.school21.chat.models;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "admin";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            String login;
            String password;
            final String SQL_SHOW_USERS = "select * from users order by user_id";
            final String SQL_ADD_USER = "insert into users (user_login, user_password) values (?, ?)";
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            System.out.println("Введите имя пользователя: ");
            login = scanner.nextLine();
            System.out.println("Введите пароль для пользователя " + login + " : ");
            password = scanner.nextLine();
            scanner.close();
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            ResultSet result = statement.executeQuery(SQL_SHOW_USERS);
            while(result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2) +" "+ result.getString(3));
            }
            User user01 = new User(7, "user-1", "1234",null,null);
            User user02 = new User(7, "user-1", "1234",null,null);
            System.out.println("_____");
            System.out.println(user01.getLogin());
            System.out.println("_____");
            System.out.println(user01.getChatRooms());
            System.out.println(user02.equals(user02));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
