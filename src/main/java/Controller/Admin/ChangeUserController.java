package Controller.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ChangeUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> BanTable;

    @FXML
    private TableColumn<?, ?> LoginTable;

    @FXML
    private TableColumn<?, ?> PasswordTable;

    @FXML
    private TextField loginField;

    @FXML
    private TextField loginField1;

    @FXML
    private TableColumn<?, ?> numberUserTable;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private PasswordField passwordField12;

    @FXML
    private TableView<?> table;

    @FXML
    void initialize() {
    }

}
