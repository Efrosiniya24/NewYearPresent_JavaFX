package Controller.Admin.Users;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import Model.Candy.*;
import Model.User.Customer;
import Model.User.SerializatorAuthorization;
import Model.User.User;
import Model.User.UserFactory;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ChangeUserController {
    @FXML
    public TableView usersTable;
    @FXML
    public Button submitLable;
    @FXML
    public TextField loginLable;
    @FXML
    public TableColumn passwordColumn;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> banColumn;

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
    private TableColumn<?, ?> lognInColumn;

    @FXML
    private TextField newLoginLable;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField repeatPasswordField;

    @FXML
    void Entry(ActionEvent event) {
        NewYearApplication.showMainAdmin();
    }

  @FXML
  public void banUsers(){
        NewYearApplication.showBunUsers();
  }
  @FXML
  public void changeUsers(){
        NewYearApplication.showChangingUsers();
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

    @FXML
    public void submit() throws IOException, ClassNotFoundException {
        String login;
        String newLogin;
        String newPassword;
        List<User> users = SerializatorAuthorization.deserialization();

        login = loginLable.getText();
        newLogin = newLoginLable.getText();
        newPassword = repeatPasswordField.getText();

        UserFactory userFactory = new UserFactory();
        Optional<User> foundUser = users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
        if (foundUser.isPresent()) {
            User user;
            int num = users.indexOf(foundUser.get());
            if (users.get(num) instanceof Customer)
                user = userFactory.createUser("customer", newLogin, newPassword, users.get(num).getBan(), users.get(num).getPresent());
            else
                user = userFactory.createUser("administrator", newLogin, newPassword, users.get(num).getBan(), null);
            users.set(num, user);
            SerializatorAuthorization.serialization(users);
            NewYearApplication.userWork();
        }

    }
}
