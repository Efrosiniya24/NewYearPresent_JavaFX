package Controller.Admin.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controller.Alerts;
import Errors.Errors;
import Model.Candy.*;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ChangingMenuController {
    public TableView<All> tableBisciut;
    public TableColumn<All, String> nameBiskuit;
    public Tab biscuitColumn;
    public TabPane tableCandy;
    public Tab marshmallowColumn;
    public Tab SweetColumn;
    @FXML
    public TextField nameOfNewCandyLable;
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
    private TableColumn<All, String> nameChocolate;

    @FXML
    private TableColumn<All, String> nameMarshmallow;

    @FXML
    private TextField nameOfCandyLable;

    @FXML
    private TableColumn<All, String> nameSweet;

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
    private TableColumn<All, Double> weightBiscuit;

    @FXML
    private TableColumn<All, Double> weightChocolate;

    @FXML
    private TableColumn<All, Double> weightMarshmallow;

    @FXML
    private TextField weightOfCandyLable;

    @FXML
    private TableColumn<All, Double> weightSweet;
    private static List<All> all;

    @FXML
    void Entry(ActionEvent event) {
        NewYearApplication.showMainAdmin();
    }

    @FXML
    void addToMenu(ActionEvent event) {
        NewYearApplication.showAddingToMenu();
    }

    @FXML
    void changeMenu(ActionEvent event) {
        NewYearApplication.menuWork();
    }

    @FXML
    void removeFromMenu(ActionEvent event) {
        NewYearApplication.showRemovingFromMenu();
    }

    @FXML
    void submit(ActionEvent event) throws IOException, ClassNotFoundException {
        all = new ArrayList<>();
        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }

        String category = categoryLable.getText().toLowerCase();
        String newName = nameOfNewCandyLable.getText().toLowerCase();
        String name = nameOfCandyLable.getText().toLowerCase();
        String weight = weightOfCandyLable.getText().toLowerCase();

        if (category.isEmpty() || newName.isEmpty() || name.isEmpty() || weight.isEmpty()) {
            Alerts.warningAlert("Вы заполнили не все поля. Будьте внимательнее)");
        } else {
            if (Errors.weight(weight) && Errors.category(category) && Errors.nameOfCandy(all, name)) {
                switch (category) {
                    case "печенье" -> {
                        All biscuit = new Biscuit();
                        String candyName = nameOfCandyLable.getText();
                        All foundCandy = null;

                        for (All candy : all) {
                            if (candy.getName().equals(candyName)) {
                                foundCandy = candy;
                                break;
                            }
                        }
                        int num = all.indexOf(foundCandy);

                        biscuit.setName(nameOfNewCandyLable.getText());
                        biscuit.setWeight(Double.parseDouble(weightOfCandyLable.getText()));

                        all.set(num, biscuit);
                    }
                    case "шоколад" -> {
                        All chocolate = new Chocolate();
                        String candyName = nameOfCandyLable.getText();
                        All foundCandy = null;

                        for (All candy : all) {
                            if (candy.getName().equals(candyName)) {
                                foundCandy = candy;
                                break;
                            }
                        }

                        int num = all.indexOf(foundCandy);

                        chocolate.setName(nameOfNewCandyLable.getText());
                        chocolate.setWeight(Double.parseDouble(weightOfCandyLable.getText()));

                        all.set(num, chocolate);
                    }
                    case "конфеты" -> {
                        All sweet = new Sweet();
                        String candyName = nameOfCandyLable.getText();
                        All foundCandy = null;

                        for (All candy : all) {
                            if (candy.getName().equals(candyName)) {
                                foundCandy = candy;
                                break;
                            }
                        }
                        int num = all.indexOf(foundCandy);

                        sweet.setName(nameOfNewCandyLable.getText());
                        sweet.setWeight(Double.parseDouble(weightOfCandyLable.getText()));

                        all.set(num, sweet);
                    }
                    case "зефир" -> {
                        All marshmallow = new Marshmallow();
                        String candyName = nameOfCandyLable.getText();
                        All foundCandy = null;

                        for (All candy : all) {
                            if (candy.getName().equals(candyName)) {
                                foundCandy = candy;
                                break;
                            }
                        }

                        int num = all.indexOf(foundCandy);

                        marshmallow.setName(nameOfNewCandyLable.getText());
                        marshmallow.setWeight(Double.parseDouble(weightOfCandyLable.getText()));

                        all.set(num, marshmallow);
                    }

                }
                saveFile(all);
                System.out.println(all);
                updatingTable();
            }
            categoryLable.clear();
            nameOfNewCandyLable.clear();
            nameOfCandyLable.clear();
            weightOfCandyLable.clear();
        }
    }

    public static void saveFile(List<All> all) throws IOException, ClassNotFoundException {
        List<All> all2 = new ArrayList<>();

        try {
            Serializator.serialization(all);
            System.out.println("Данные записаны в файл");
            return;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }
        all2.addAll(Serializator.deserialization());

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
        nameOfNewCandyLable.clear();
        nameOfCandyLable.clear();
        weightOfCandyLable.clear();
    }
}
