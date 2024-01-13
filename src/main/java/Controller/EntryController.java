package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import Model.Candy.All;
import Model.User.IteratorUser;
import Model.User.User;
import Model.User.UserFactory;
import com.example.laba5.NewYearApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EntryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EntryButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink regestrationLink;

    private static int indexUser = -1;
    private static List<User> users = new ArrayList<>(Collections.singletonList(null));

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        EntryController.users = users;
    }

    public static User getUser() {
        return users.get(0);
    }

    @FXML
    public void registration() {
        NewYearApplication.showRegistration();
    }


    @FXML
    void Entry(ActionEvent event) throws IOException, ClassNotFoundException, InterruptedException {
        String login = loginField.getText();
        System.out.println(loginField.getText());
        String password = passwordField.getText();

        if (login.isEmpty() && password.isEmpty()) {
            Alerts.warningAlert("Введите логин и пароль");
        }
        else {
            List<User> users = SerializatorAuthorization.deserialization();
            if (users != null) {
                IteratorUser<User> iterator = new IteratorUser<>(users, 0);
                for (int i = 0; iterator.hasNext(); i++) {
                    User user = iterator.next();
                    if (user.getPassword().equals(password) && user.getLogin().equals(login)) {
                        indexUser = i;
                        break;
                    }
                }
            }
            if (indexUser == -1) {
                Alerts.warningAlert("""
                        Вы не зарегистрированы(!
                        Пройдите регистрацию или введите логин и пароль заново
                        Будьте внимательнее)
                        """);
            } else {
                if (!users.get(indexUser).getBan()) {
                    User user = operations(login, password, users.get(indexUser).getPresent());
                    users.set(indexUser, user);
                    indexUser = -1;
                } else Alerts.warningAlert("К сожалению, мы не можем предоставить Вам доступ(. Вы заблокированы");
            }
            SerializatorAuthorization.serialization(users);
        }
    }

    public static User operations(String login, String password, List<All> present) throws InterruptedException, IOException, ClassNotFoundException {
        UserFactory userFactory = new UserFactory();
        User user;
        if (password.equals("1111") && login.equals("admin")) {
            user = userFactory.createUser("administrator", login, password, false, present);
            users.set(0, user);
            NewYearApplication.showMainAdmin();
        } else {
            user = userFactory.createUser("customer", login, password, false, present);
            users.set(0, user);
            NewYearApplication.showMainCustomer();
        }
        return user;
    }
}
