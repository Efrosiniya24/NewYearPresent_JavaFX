package Controller.Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BanUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> BanTable;

    @FXML
    private TableColumn<?, ?> LoginTable;

    @FXML
    private TextField NumberUserLable;

    @FXML
    private TableColumn<?, ?> PasswordTable;

    @FXML
    private TableColumn<?, ?> numberUserTable;

    @FXML
    private TableView<?> table;

    @FXML
    void initialize() {
    }

}
