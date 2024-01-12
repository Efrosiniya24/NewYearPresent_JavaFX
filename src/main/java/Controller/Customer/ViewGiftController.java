package Controller.Customer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.EntryController;
import Model.Candy.*;
import Model.User.User;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ViewGiftController {
    private List<All> all;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab SweetColumn;

    @FXML
    private Tab biscuitColumn;

    @FXML
    private Tab chocolateColumn;

    @FXML
    private ImageView exit;

    @FXML
    private Button exitButton;

    @FXML
    private Button makeButton;

    @FXML
    private Tab marshmallowColumn;

    @FXML
    private TableColumn<?, ?> nameBiskuit;

    @FXML
    private TableColumn<?, ?> nameChocolate;

    @FXML
    private TableColumn<?, ?> nameMarshmallow;

    @FXML
    private TableColumn<?, ?> nameSweet;

    @FXML
    private TableView<All> tableBisciut;

    @FXML
    private TabPane tableCandy1;

    @FXML
    private TableView<All> tableChocolate;

    @FXML
    private TableView<All> tableMarshmallow;

    @FXML
    private TableView<All> tableSweet;

    @FXML
    private Button viewPresentButton;

    @FXML
    private TableColumn<?, ?> weightBiscuit;

    @FXML
    private Button weightButton;

    @FXML
    private TableColumn<?, ?> weightChocolate;

    @FXML
    private TableColumn<?, ?> weightMarshmallow;

    @FXML
    private TableColumn<?, ?> weightSweet;

    @FXML
    void exit(ActionEvent event) {
        NewYearApplication.showAuthorization();
    }

    @FXML
    void makePresent(ActionEvent event) {
        NewYearApplication.showMakeGift();
    }

    @FXML
    public void showChocolate() {
        List<All> chocolateGift = Chocolate.getChocolateGift();
        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(chocolateGift);

        nameChocolate.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightChocolate.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableChocolate.setItems(allObservableList);
    }

    @FXML
    public void showBiscuits() {
        List<All> biscuitsGift = Biscuit.getBiscuitsGift();
        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(biscuitsGift);

        nameBiskuit.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightBiscuit.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableBisciut.setItems(allObservableList);
    }
    @FXML
    public void showMarshmallow() {
        List<All> marshmallow = Marshmallow.getMarshmallowGift();
        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(marshmallow);

        nameMarshmallow.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightMarshmallow.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableMarshmallow.setItems(allObservableList);
    }

    @FXML
    public void showSweet() {
        List<All> sweet = Sweet.getSweetGift();
        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(sweet);

        nameSweet.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightSweet.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableSweet.setItems(allObservableList);
    }

    @FXML
    void viewPresent(ActionEvent event) {
        NewYearApplication.showMainCustomer();
    }

    @FXML
    void viewWeigthOfPresent(ActionEvent event) {
        NewYearApplication.showWeightOfGift();
    }

    @FXML
    void initialize() {
        boolean t = true;
        double weightt = 0;
        User user = EntryController.getUser();
        int size = EntryController.getUser().getPresent().size();
        for (int i = 0; i < size; i++) {
            weightt += user.getPresent().get(i).getAllWeightPresent();
        }
        if (weightt != 0) {
            t = false;
            All biscuit = new Biscuit();
            if (biscuit.present() != null)
                biscuit.viewGift(user);

            All cake = new Chocolate();
            if (cake.present() != null)
                cake.viewGift(user);

            All marshmallow = new Marshmallow();
            if (marshmallow.present() != null)
                marshmallow.viewGift(user);

            All sweet = new Sweet();
            if (sweet.present() != null)
                sweet.viewGift(user);

            System.out.println("Общий вес: " + weightt + "\n");
            showBiscuits();
        }
    }

}
