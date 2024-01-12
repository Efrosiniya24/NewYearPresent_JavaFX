package Controller.Customer;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.laba5.NewYearApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class WeightOfGiftController {

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
    private Label weightOfGift;

    @FXML
    void exit(ActionEvent event) {
        NewYearApplication.userWork();
    }

    @FXML
    void makePresent(ActionEvent event) {
        NewYearApplication.showMakeGift();
    }

    @FXML
    void viewPresent(ActionEvent event) {
        NewYearApplication.showViewOfGift();
    }

    @FXML
    void viewWeigthOfPresent(ActionEvent event) {
        NewYearApplication.showMainCustomer();
    }

    @FXML
    void weightOfGift(MouseEvent event) {

    }

    @FXML
    void initialize() {
        double weight = MakeGiftController.count();
        if (weight == 0)
            weightOfGift.setText("Ваш подарок пуст");
        else weightOfGift.setText(weight + " г");
    }

}
