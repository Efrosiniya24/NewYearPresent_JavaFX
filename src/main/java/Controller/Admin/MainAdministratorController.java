package Controller.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.laba5.NewYearApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainAdministratorController {

    public Button exitButton;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changeMenuButton;

    @FXML
    private Button changeUsersButton;
    @FXML
    private ImageView exit;

    @FXML
    void Entry(ActionEvent event) {
        NewYearApplication.showAuthorization();
    }

    @FXML
    void MenuWork() {
        NewYearApplication.menuWork();
    }

    @FXML
    void userWork() {
        NewYearApplication.userWork();
    }

}
