package Controller.Admin.Users;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.laba5.NewYearApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class UserAdminController {

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
    private TableColumn<?, ?> passwordColumn;

    @FXML
    private TableView<?> usersTable;



    @FXML
    public void Entry(ActionEvent event) {
        NewYearApplication.userWork();
    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void changingUsers(){
        NewYearApplication.showChangingUsers();
    }

}
