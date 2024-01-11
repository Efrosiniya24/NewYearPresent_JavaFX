package Controller.Customer;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.laba5.NewYearApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainCustomerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView exit;

    @FXML
    private Button exitButton;

    @FXML
    private Button makeButton;

    @FXML
    private Button viewPresentButton;

    @FXML
    private Button weightButton;

    @FXML
    void exit(ActionEvent event) {
        NewYearApplication.showAuthorization();
    }

    @FXML
    void makePresent(ActionEvent event) {
        NewYearApplication.showMakeGift();
    }

    @FXML
    void viewPresent(ActionEvent event) {

    }

    @FXML
    void viewWeigthOfPresent(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
