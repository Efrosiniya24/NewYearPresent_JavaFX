package Controller.Admin.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.User.Customer;
import Model.User.SerializatorAuthorization;
import Model.User.User;
import Model.User.UserFactory;
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

public class BanController {

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
    private TextField loginLable;

    @FXML
    private TableColumn<?, ?> lognInColumn;

    @FXML
    private TableColumn<?, ?> passwordColumn;

    @FXML
    private Button submitLable;

    @FXML
    private TableView<User> usersTable;

    @FXML
    void Entry(ActionEvent event) {
        NewYearApplication.showMainAdmin();
    }

    @FXML
    void changingUsers(ActionEvent event) {
        NewYearApplication.showChangingUsers();
    }

    @FXMLЛ
    public void banUsers(){
        NewYearApplication.showBunUsers();
    }

    @FXML
    void submit(ActionEvent event) throws IOException, ClassNotFoundException {
        List<User> users = SerializatorAuthorization.deserialization();
        String login = loginLable.getText();
        UserFactory userFactory = new UserFactory();

        Optional<User> foundUser = users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
        if (foundUser.isPresent()) {
            User user;
            int num = users.indexOf(foundUser.get());
            if (users.get(num) instanceof Customer)
                user = userFactory.createUser("customer", users.get(num).getLogin(), users.get(num).getPassword(), !users.get(num).getBan(), users.get(num).getPresent());
            else
                user = userFactory.createUser("administrator", users.get(num).getLogin(), users.get(num).getPassword(), !users.get(num).getBan(), null);
            users.set(num, user);
            SerializatorAuthorization.serialization(users);
            NewYearApplication.userWork();
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
