package Controller.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import Model.Candy.*;
import com.example.laba5.NewYearApplication;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class AddingToMenuController {

    public TableColumn banColumn;
    public TableColumn lognInColumn;
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
        List<All> all = new ArrayList<>();

        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }

        ObservableList<All> candyObservableList = null;

        tableMenuAdmin.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab != null) {
                String selectedColumn = newTab.getText();
                switch (selectedColumn) {
                    case "Зефир" -> {
                        All marshmallow = new Marshmallow();
                        candyObservableList.addAll(marshmallow.view(all));
                        nameMarshmallow.setCellValueFactory(new PropertyValueFactory<>("name"));
                        weightMarshmallow.setCellValueFactory(new PropertyValueFactory<>("weight"));
                        tableBiscuit.setItems(candyObservableList);
                    }
                    case "Шоколад" -> {
                        All chocolate = new Chocolate();
                        candyObservableList.addAll(chocolate.view(all));
                        nameChocolate.setCellValueFactory(new PropertyValueFactory<>("name"));
                        weightChocolate.setCellValueFactory(new PropertyValueFactory<>("weight"));
                        tableChocolate.setItems(candyObservableList);
                    }
                    case "Печенье" -> {
                        All biscuit = new Biscuit();
                        candyObservableList.addAll(biscuit.view(all));
                        nameBiscuit.setCellValueFactory(new PropertyValueFactory<>("name"));
                        weightBiscuit.setCellValueFactory(new PropertyValueFactory<>("weight"));
                        tableBiscuit.setItems(candyObservableList);
                    }
                    case "Конфеты" -> {
                        All sweet = new Sweet();
                        candyObservableList.addAll(sweet.view(all));
                        nameSweet.setCellValueFactory(new PropertyValueFactory<>("name"));
                        weightSweet.setCellValueFactory(new PropertyValueFactory<>("weight"));
                        tableSweet.setItems(candyObservableList);
                    }
                }
            }
        });
    }

    @FXML
    public void submit() throws IOException, ClassNotFoundException {
        List<All> all = new ArrayList<>();
        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }

        String category = categoryLable.getText().toLowerCase();
        switch (category) {
            case "печенье" -> {
                try {
                    FacadeAddMenu facade = new FacadeAddMenu();
                    all.add(facade.addBiscuitMenu(nameOfCandyLable.getText(), Double.parseDouble(weightOfCandyLable.getText())));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            case "шоколад" -> {
                FacadeAddMenu facade = new FacadeAddMenu();
                all.add(facade.addChocolateMenu(nameOfCandyLable.getText(), Double.parseDouble(weightOfCandyLable.getText())));
            }
            case "конфеты" -> {
                FacadeAddMenu facade = new FacadeAddMenu();
                all.add(facade.addSweetMenu(nameOfCandyLable.getText(), Double.parseDouble(weightOfCandyLable.getText())));
            }
            case "зефир" -> {
                FacadeAddMenu facade = new FacadeAddMenu();
                all.add(facade.addMarshmallowMenu(nameOfCandyLable.getText(), Double.parseDouble(weightOfCandyLable.getText())));
            }
        }
        saveFile(all);
        System.out.println(all);
        NewYearApplication.showAddingToMenu();
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

}
