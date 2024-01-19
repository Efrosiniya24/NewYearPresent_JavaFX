package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import Errors.Errors;
import Model.Candy.All;
import Model.User.Customer;
import Model.User.User;
import com.example.laba5.NewYearApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    static List<User> users = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink regestrationLink;

    @FXML
    private Button registrationButton;

    @FXML
    private PasswordField repeatPasswordField;

    @FXML
    void entry(ActionEvent event) {
        NewYearApplication.showAuthorization();
    }

    @FXML
    void registration(ActionEvent event) throws IOException, ClassNotFoundException, InterruptedException {
        List<User> users = SerializatorAuthorization.deserialization();
        String login = loginField.getText();
        String password = passwordField.getText();
        String repeatPassword = repeatPasswordField.getText();
        boolean u = true;
        if (login.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            Alerts.warningAlert("Не все поля заполнены. Будьте внимательнее)");
        }
        else if (Errors.printPasswort(repeatPassword, password)) {
            List<All> p = new ArrayList<>();
            for (User user : users) {
                if (user.getPassword().equals(password) && user.getLogin().equals(login) || password.equals("1111") && login.equals("admin")) {
                    Alerts.warningAlert("Такой пользовтель уже существует. Повторите ввод");
                    u = false;
                }
            }
            if (u) {
// EntryController.setIndexUser(users.size());
                System.out.println(users);
                System.out.println(users.size());
                users = SerializatorAuthorization.deserialization();
                User customer = new Customer(login, password, false, p);
                users.add(customer);
                SerializatorAuthorization.serialization(users);
//                EntryController.setUserr(customer);////////////////////////////////////
                EntryController.setUsers(users);
                EntryController.operations(login, password, p);
            }
        }
        loginField.clear();
        passwordField.clear();
        repeatPasswordField.clear();
    }

    @FXML
    void initialize() {

    }
}
