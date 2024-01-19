package com.example.laba5;

import Controller.Alerts;
import Controller.SerializatorAuthorization;
import Model.Candy.All;
import Model.User.Administrator;
import Model.User.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewYearApplication extends Application {
    private static Stage primaryStage;
    public static final int maxWidth = 700;
    public static final int maxHeight = 400;
    public static void main(String[] args) {
        launch();
    }
    public static Image image;

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
//        List<User> user = new ArrayList<>();
//        user.add(new Administrator("admin", "1111", false, null));
//        SerializatorAuthorization.serialization(user);
        image = new Image(NewYearApplication.class.getResourceAsStream("warning.png"));
        List<All> all = new ArrayList<>();
        System.out.println(all);
        System.out.println(SerializatorAuthorization.deserialization());
        stage.getIcons().add(new Image(Objects.requireNonNull(NewYearApplication.class.getResourceAsStream("present.png"))));
        stage.setMinWidth(maxWidth);stage.setMinHeight(maxHeight);
        primaryStage = stage;
        stage.setTitle("Авторизация");
        showAuthorization();
    }

    public static void showAuthorization() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(NewYearApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);

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

    public static void showDeleteUsers(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("deleteUser.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Удаление пользователей");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showRegistration(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("registration.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Регистрация");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showMainCustomer(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("mainCustomer.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Меню");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showMakeGift(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("makeGift.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Создание подарка");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void showWeightOfGift(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("weigthOfGift.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Вес подарка");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void showViewOfGift(){
        try {
            FXMLLoader loader = new FXMLLoader(NewYearApplication.class.getResource("viewGift.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Подарок");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}