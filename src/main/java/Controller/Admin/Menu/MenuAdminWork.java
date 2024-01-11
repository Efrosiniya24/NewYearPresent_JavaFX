package Controller.Admin.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.Candy.*;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class MenuAdminWork {
    @FXML
    public TableView<All> tableBisciut;
    @FXML
    public TableColumn <?, ?>nameBiskuit;
    @FXML
    public Tab biscuitColumn;
    @FXML
    public TabPane tableCandy;
    @FXML
    public Tab marshmallowColumn;
    @FXML
    public Tab SweetColumn;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab BiscuitColumn;

    @FXML
    private Tab MarshmalloColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Tab chocolateColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private ImageView exit;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<All, String> nameBiscuit;

    @FXML
    private TableColumn<All, String> nameChocolate;

    @FXML
    private TableColumn<All, String> nameMarshmallow;

    @FXML
    private TableColumn<All, String> nameSweet;

    @FXML
    private Tab sweetColumn;

    @FXML
    private TableView<All> tableBiscuit;

    @FXML
    private TableView<All> tableChocolate;

    @FXML
    private TableView<All> tableMarshmallow;

    @FXML
    private TabPane tableMenuAdmin;

    @FXML
    private TableView<All> tableSweet;

    @FXML
    private TableColumn<All, Double> weightBiscuit;

    @FXML
    private TableColumn<All, Double> weightChocolate;

    @FXML
    private TableColumn<All, Double> weightMarshmallow;

    @FXML
    private TableColumn<All, Double> weightSweet;

    private static List<All> all;

    @FXML
    void Entry(ActionEvent event) {

    }

    @FXML
    void addToMenu(ActionEvent event) {
        NewYearApplication.showAddingToMenu();
    }

    @FXML
    void changeMenu(ActionEvent event) {
        NewYearApplication.showChangingMenu();
    }

    @FXML
    void removeFromMenu(ActionEvent event) {
        NewYearApplication.showRemovingFromMenu();
    }


    @FXML
    public void initialize() {
       all = new ArrayList<>();

        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }
        System.out.println(all);
        showBiscuits();
    }

        public void entry() {
            NewYearApplication.showMainAdmin();
        }
@FXML
public void showChocolate() {
    List<All> alll = new ArrayList<>();

    try {
        alll.addAll(Serializator.deserialization());
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Ошибка ввода-вывода\n");
    }
    List<All> chocolates = new ArrayList<>();
    for (All alls : alll)
        if (alls instanceof Chocolate)
            chocolates.add(alls);
    System.out.println(chocolates);

    ObservableList<All> allObservableList = FXCollections.observableArrayList(chocolates);

    nameChocolate.setCellValueFactory(new PropertyValueFactory<>("name"));
    weightChocolate.setCellValueFactory(new PropertyValueFactory<>("weight"));
    tableChocolate.setItems(allObservableList);
}

    @FXML
    public void showBiscuits() {
        List<All> biscuits = new ArrayList<>();
        for (All alls : all)
            if (alls instanceof Biscuit)
                biscuits.add(alls);
        System.out.println(biscuits);

        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(biscuits);

        nameBiskuit.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightBiscuit.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableBisciut.setItems(allObservableList);
    }

    @FXML
    public void showMarshmallow() {
        List<All> marshmallow = new ArrayList<>();
        for (All alls : all)
            if (alls instanceof Marshmallow)
                marshmallow.add(alls);
        System.out.println(marshmallow);

        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(marshmallow);

        nameMarshmallow.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightMarshmallow.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableMarshmallow.setItems(allObservableList);
    }

    @FXML
    public void showSweet() {
        List<All> sweet = new ArrayList<>();
        for (All alls : all)
            if (alls instanceof Sweet)
                sweet.add(alls);
        System.out.println(sweet);

        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(sweet);

        nameSweet.setCellValueFactory(new PropertyValueFactory<>("name"));
        weightSweet.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableSweet.setItems(allObservableList);
    }
}
