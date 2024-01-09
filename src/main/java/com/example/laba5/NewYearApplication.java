package com.example.laba5;

import Model.User.Administrator;
import Model.User.SerializatorAuthorization;
import Model.User.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewYearApplication extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
//        List<User> user = new ArrayList<>();
//        user.add(new Administrator("admin", "1111", false, null));
//        SerializatorAuthorization.serialization(user);
        primaryStage = stage;
        stage.setTitle("Авторизация");
        showAuthorization();
    }

    public static void showAuthorization() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(NewYearApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showMainAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("MainAdmin.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Меню");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void menuWork() {
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("changeMenu.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Конструктор меню");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showAddingToMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("addingToMenu.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Добавление в меню");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showRemovingFromMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("removeFromMenu.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Удаление из меню");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void showChangingMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("changingMenu.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Изменение меню");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void userWork(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("UsersAdmin.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Работа с пользователями");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void showChangingUsers(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("changeUser.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Изменение данных пользователей");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showBunUsers(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("banUser.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Блокировка пользователей");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}