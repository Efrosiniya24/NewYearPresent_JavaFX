package Controller.Admin.Menu;

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
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class MenuAdminWork {

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
    private TableColumn<?, ?> nameBiscuit;

    @FXML
    private TableColumn<?, ?> nameChocolate;

    @FXML
    private TableColumn<?, ?> nameMarshmallow;

    @FXML
    private TableColumn<?, ?> nameSweet;

    @FXML
    private Tab sweetColumn;

    @FXML
    private TableView<All> tableBiscuit;

    @FXML
    private TableView<All> tableChocolate;

    @FXML
    private TableView<?> tableMarshmallow;

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
    private TableColumn<?, ?> weightSweet;

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
                        tableSweet.setItems(candyObservableList);
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

        public void entry() {
            NewYearApplication.showMainAdmin();
        }


//        Tab column = new Tab();
//        column.set
//        button.setOnAction((ActionEvent event) -> {
//            String column = button.getText();
//            switch (column) {
//                case "Зефир" -> all.add(facade.addMarshmallowMenu());
//                case "Шоколад" -> all.add(facade.addChocolateMenu());
//                case "Печенье" -> all.add(facade.addBiscuitMenu());
//                case "Конфеты" -> all.add(facade.addSweetMenu();
//            }
//        });

//        String column = Tab.;
//        System.out.println(column);
//        all.add(facade.addBiscuitMenu());
//        List<User> usersList = MainAdmin.getUsers();
//        ObservableList<User> userObservableList = FXCollections.observableArrayList(usersList);
//        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
//        roleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
//        accessColumn.setCellValueFactory(new PropertyValueFactory<>("hasAccess"));
//        userTableView.setItems(userObservableList);

}
