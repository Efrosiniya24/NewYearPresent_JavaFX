package Controller.Admin.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.SerializatorAuthorization;
import Model.User.User;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class UserAdminController {

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
    private TableColumn<User, String> lognInColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableView<User> usersTable;



    @FXML
    public void Entry(ActionEvent event) {
        NewYearApplication.showMainAdmin();
    }

    @FXML
    public void initialize() {
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

    @FXML
    public void deleteUsers(){
        NewYearApplication.showDeleteUsers();
    }

    @FXML
    public void banUsers(){
        NewYearApplication.showBunUsers();
    }
    @FXML
    public void changingUsers(){
        NewYearApplication.showChangingUsers();
    }

}
