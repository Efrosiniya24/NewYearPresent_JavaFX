package Controller.Admin.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.Alerts;
import Controller.SerializatorAuthorization;
import Errors.Errors;
import Model.User.User;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class deleteUsersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<User, Boolean> banColumn;

    @FXML
    private Button bunButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ImageView exit;

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginLable;

    @FXML
    private TableColumn<User, String> lognInColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private Button submitLable;

    @FXML
    private TableView<User> usersTable;

    @FXML
    void Entry(ActionEvent event) {
        NewYearApplication.userWork();
    }

    @FXML
    public void deleteUsers() {
        NewYearApplication.userWork();
    }

    @FXML
    void banUsers(ActionEvent event) {
        NewYearApplication.showBunUsers();
    }

    @FXML
    void changingUsers(ActionEvent event) {
        NewYearApplication.showChangingUsers();
    }

    @FXML
    void delete(ActionEvent event) throws IOException, ClassNotFoundException {
        List<User> users = SerializatorAuthorization.deserialization();
        String login = loginLable.getText();
        if (login.isEmpty()) {
            Alerts.warningAlert("ВЫ не ввели логин. Будьте внимательнее)");
        } else {
            if(Errors.loginOfUser(users, login)) {
                Optional<User> foundUser = users.stream()
                        .filter(user -> user.getLogin().equals(login))
                        .findFirst();
                if (foundUser.isPresent()) {
                    int num = users.indexOf(foundUser.get());
                    users.remove(num);
                    SerializatorAuthorization.serialization(users);
                    NewYearApplication.userWork();
                }
            }
            loginLable.clear();
        }
    }

    @FXML
    void initialize() {
        List<User> users = new ArrayList<>();

        try {
            users.addAll(SerializatorAuthorization.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }

        ObservableList<User> userObservableList = FXCollections.observableArrayList(users);

        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        lognInColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        banColumn.setCellValueFactory(new PropertyValueFactory<>("ban"));
        usersTable.setItems(userObservableList);

    }

}
