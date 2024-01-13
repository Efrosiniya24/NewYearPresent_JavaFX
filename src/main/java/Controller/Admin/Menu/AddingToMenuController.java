package Controller.Admin.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import Controller.Alerts;
import Errors.Errors;
import Model.Candy.*;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class AddingToMenuController {
    public TableView<All> tableBisciut;
    public TableColumn<All, String> nameBiskuit;
    public Tab biscuitColumn;
    public TabPane tableCandy;
    public Tab marshmallowColumn;
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
    private TextField categoryLable;

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
    private TableColumn<?, ?> nameBiscuit;

    @FXML
    private TableColumn<?, ?> nameChocolate;

    @FXML
    private TableColumn<?, ?> nameMarshmallow;

    @FXML
    private TextField nameOfCandyLable;

    @FXML
    private TableColumn<?, ?> nameSweet;

    @FXML
    private Button submitLable;

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
    private TableColumn<?, ?> weightBiscuit;

    @FXML
    private TableColumn<?, ?> weightChocolate;

    @FXML
    private TableColumn<?, ?> weightMarshmallow;

    @FXML
    private TextField weightOfCandyLable;

    @FXML
    private TableColumn<?, ?> weightSweet;
    private static List<All> all;

    @FXML
    void Entry(ActionEvent event) {
        NewYearApplication.showMainAdmin();
    }

    @FXML
    void addToMenu(ActionEvent event) {
        NewYearApplication.menuWork();
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
    void initialize() {
        all = new ArrayList<>();
        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }
        showBiscuits();
    }

    @FXML
    public void submit() throws IOException, ClassNotFoundException {
        all = new ArrayList<>();
        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }

        String weight = weightOfCandyLable.getText();
        String category = categoryLable.getText().toLowerCase();
        String name = nameOfCandyLable.getText();

        if (weight.isEmpty() && category.isEmpty() && name.isEmpty()) {
            Alerts.warningAlert("Вы заполнили не все поля. Будьте внимательнее)");
        } else {
            if (Errors.category(category) && Errors.weight(weight)) {
                switch (category) {
                    case "печенье" -> {
                        try {
                            FacadeAddMenu facade = new FacadeAddMenu();
                            all.add(facade.addBiscuitMenu(nameOfCandyLable.getText(), Double.parseDouble(weight)));
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    case "шоколад" -> {
                        FacadeAddMenu facade = new FacadeAddMenu();
                        all.add(facade.addChocolateMenu(nameOfCandyLable.getText(), Double.parseDouble(weight)));
                    }
                    case "конфеты" -> {
                        FacadeAddMenu facade = new FacadeAddMenu();
                        all.add(facade.addSweetMenu(nameOfCandyLable.getText(), Double.parseDouble(weight)));
                    }
                    case "зефир" -> {
                        FacadeAddMenu facade = new FacadeAddMenu();
                        all.add(facade.addMarshmallowMenu(nameOfCandyLable.getText(), Double.parseDouble(weight)));
                    }
                }
                saveFile();
                System.out.println(all);
                updatingTable();
            }
            weightOfCandyLable.clear();
            categoryLable.clear();
            nameOfCandyLable.clear();
        }
    }

    public static void saveFile() throws IOException, ClassNotFoundException {
        try {
            Serializator.serialization(all);
            System.out.println("Данные записаны в файл");
            return;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }
//        all2.addAll(Serializator.deserialization());
    }

    @FXML
    public void showChocolate() {
        List<All> chocolates = new ArrayList<>();
        for (All alls : all)
            if (alls instanceof Chocolate)
                chocolates.add(alls);
        System.out.println(chocolates);

        ObservableList<All> allObservableList = FXCollections.observableArrayList();
        allObservableList.clear();
        allObservableList.addAll(chocolates);

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

    public void updatingTable() {
        Tab selectedTab = tableCandy.getSelectionModel().getSelectedItem();
        String tabTitle = null;
        if (selectedTab != null) {
            tabTitle = selectedTab.getText();
            System.out.println("Название открытой вкладки: " + tabTitle);
        } else {
            System.out.println("Нет открытых вкладок");
        }
        switch (Objects.requireNonNull(tabTitle).toLowerCase()) {
            case "печенье" -> showBiscuits();
            case "шоколад" -> showChocolate();
            case "зефир" -> showMarshmallow();
            case "конфеты" -> showSweet();
        }
        categoryLable.clear();
        nameOfCandyLable.clear();
        weightOfCandyLable.clear();
    }
}
