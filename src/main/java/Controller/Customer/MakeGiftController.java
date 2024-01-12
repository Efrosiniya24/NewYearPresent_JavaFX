package Controller.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import Controller.EntryController;
import Controller.SerializatorAuthorization;
import Model.Candy.*;
import Model.User.User;
import com.example.laba5.NewYearApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.ImageView;

public class MakeGiftController {
    private static double[] weightt = new double[4];
    public static List<All> all2 = new ArrayList<>();
    public static List<All> all3 = new ArrayList<>();
    private static String name;
    private static List<All> all = new ArrayList<>();
    private static final All biscuit = new Biscuit();
    private static final All chocolate = new Chocolate();
    private static final All sweet = new Sweet();
    private static final All marshmallow = new Marshmallow();
    private static double minWeight;
    private static double maxWeight;
    private static int useWeight;
    private static boolean useW;
    private static int useName;
    private static boolean useN;
    private static int sort;
    private static boolean cancelSort;
    private static List<All> present1 = new ArrayList<>();
    @FXML
    public TableView<All> tableChocolate;
    @FXML
    public TableView<All> tableSweet;
    @FXML
    public TableView<All> tableMarshmallow;
    @FXML
    public TableView<All> tableBisciut;
    @FXML
    public TextField categoryLable;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab SweetColumn;

    @FXML
    private Button addFilter;

    @FXML
    private Button addSortAscending;

    @FXML
    private Button addSortDecreasing;

    @FXML
    private Tab biscuitColumn;

    @FXML
    private Button cancelFilterTaste;

    @FXML
    private Button cancelFilterWeight;

    @FXML
    private Button cancelSorting;

    @FXML
    private Tab chocolateColumn;

    @FXML
    private ImageView exit;

    @FXML
    private Button exitButton;

    @FXML
    private Button makeButton113;

    @FXML
    private Tab marshmallowColumn;

    @FXML
    private  TextField maxLable;

    @FXML
    private  TextField minLable;

    @FXML
    private TableColumn<?, ?> nameBiskuit;

    @FXML
    private TableColumn<All, ?> nameChocolate;

    @FXML
    private TextField nameLable;

    @FXML
    private TableColumn<?, ?> nameMarshmallow;

    @FXML
    private TableColumn<?, ?> nameSweet;

    @FXML
    private TextField quantityLable;

    @FXML
    private Button shoppingCartButton;

    @FXML
    private TabPane tableCandy;

    @FXML
    private TextField tasteLable;

    @FXML
    private TableColumn<?, ?> weightBiscuit;

    @FXML
    private TableColumn<?, ?> weightChocolate;

    @FXML
    private TableColumn<?, ?> weightMarshmallow;

    @FXML
    private TableColumn<?, ?> weightSweet;

    @FXML
    void addFilter(ActionEvent event) throws InterruptedException {
        Filter filter = null;

        String max = maxLable.getText();
        String min = minLable.getText();
        String taste = tasteLable.getText();
        System.out.println(taste);

        if (!max.isEmpty() && !min.isEmpty()) {
            System.out.println("Wetrht");
            useW = true;
            useWeight = 1;
        }
        if (!taste.isEmpty()) {
            System.out.println("gbnh");
            useN = true;
            useName = 1;
        }
        filter = useDeleteFilter(filter, useWeight, useName, cancelSort);
        updatingTable();
    }

    public void updatingTable(){
        Tab selectedTab = tableCandy.getSelectionModel().getSelectedItem();
        String tabTitle = null;
        if (selectedTab != null) {
            tabTitle = selectedTab.getText();
            System.out.println("Название открытой вкладки: " + tabTitle);
        } else {
            System.out.println("Нет открытых вкладок");
        }
        switch(Objects.requireNonNull(tabTitle).toLowerCase()){
            case "печенье" -> showBiscuits();
            case "шоколад" -> showChocolate();
            case "зефир" ->showMarshmallow();
            case "конфеты" -> showSweet();
        }
        maxLable.clear();
        minLable.clear();
        tasteLable.clear();
    }

    public Filter useDeleteFilter(Filter filter, int useWeight, int useName, boolean cancelSort) throws InterruptedException {
        all2.clear();
        if (useName == 0 && useWeight == 0 && !cancelSort) {
            all2.addAll(all);
            if (sort == 1) sort1();
            else if (sort == 2) sort2();
            return filter;
        } else if ((useName == 0 || useWeight == 0) && !cancelSort) {
            all2.addAll(all);
            if (sort == 1) sort1();
            else if (sort == 2) sort2();
        } else if (cancelSort)
            all2.addAll(all);
        else
            all2.addAll(all3);

        if (useWeight == 1) {
            if (useW) {
                minWeight = Double.parseDouble(minLable.getText());
                maxWeight = Double.parseDouble(maxLable.getText());
            }
            filter = new Filter(maxWeight, minWeight);
            all2 = filter.filterByWeight();
            useW = false;
        }
        if (useName == 1) {
            if (useN) {
                name = tasteLable.getText();
            }
            filter = new Filter(name);
            all2 = filter.filterByWord();
            useN = false;
        }
        updatingTable();
        return filter;
    }

    public static void sort1() throws InterruptedException {
        SortAscending sortAscending = new SortAscending();
        sortAscending.threadSort.join();
        all3.clear();
        all3.addAll(all2);
    }

    public static void sort2() {
        SortDecreasing sortDecreasing = new SortDecreasing();
        sortDecreasing.start();
    }


    @FXML
    void addSortAscending(ActionEvent event) throws InterruptedException {
        sort = 1;
        sort1();
        cancelSort = false;
//        NewYearApplication.showMakeGift();
        updatingTable();
    }

    @FXML
    void addSortDecreasing(ActionEvent event) {
        sort = 2;
        sort2();
        cancelSort = false;
//        NewYearApplication.showMakeGift();
        updatingTable();
    }

    @FXML
    void cancelFilterTaste(ActionEvent event) throws InterruptedException {
        cancelFilter(false);
        updatingTable();
    }

    @FXML
    void cancelFilterWeight(ActionEvent event) throws InterruptedException {
        cancelFilter(true);
        updatingTable();
    }

    public void cancelFilter(Boolean operation) throws InterruptedException {
        Filter filter = null;

        if (operation) {
            useW = true;
            useWeight = 0;
        } else {
            useN = true;
            useName = 0;
        }
        filter = useDeleteFilter(filter, useWeight, useName, cancelSort);
    }

    @FXML
    void cancelSorting(ActionEvent event) throws InterruptedException {
        all3.clear();
        all3.addAll(all);
        useW = false;
        useN = false;
        cancelSort = true;
        useDeleteFilter(null, useWeight, useName, true);
        updatingTable();
    }

    @FXML
    void exit(ActionEvent event) {
        NewYearApplication.showMainCustomer();
    }

    @FXML
    void makePresent(ActionEvent event) {

    }


    @FXML
    void shoppingCart(ActionEvent event) throws IOException {
        String category = categoryLable.getText().toLowerCase();
        String name = nameLable.getText();
        int quantity = Integer.parseInt(quantityLable.getText());
        User user = EntryController.getUser();
        System.out.println(user.getPresent());
        switch (category) {
            case "печенье" -> weightt[0] += biscuit.choose(all2, user, quantity,name);
            case "шоколад" -> weightt[1] += chocolate.choose(all2, user, quantity,name);
            case "зефир" -> weightt[2] += marshmallow.choose(all2, user, quantity,name);
            case "конфеты" -> weightt[3] += sweet.choose(all2, user, quantity,name);

        }
        present1.clear();
        if (!Biscuit.biscuitsGift.isEmpty())
            present1.addAll(Biscuit.biscuitsGift);
        if (!Chocolate.chocolateGift.isEmpty())
            present1.addAll(Chocolate.chocolateGift);
        if (!Marshmallow.marshmallowGift.isEmpty())
            present1.addAll(Marshmallow.marshmallowGift);
        if (!Sweet.sweetGift.isEmpty())
            present1.addAll(Sweet.sweetGift);
        user.setPresent(present1);
//            return present1;
        List<User>users = EntryController.getUsers();
        SerializatorAuthorization.serialization(users);
        System.out.println(present1);
        categoryLable.clear();
        nameLable.clear();
        quantityLable.clear();
    }


    @FXML
    public void showChocolate() {
        List<All> chocolates = new ArrayList<>();
        for (All alls : all2)
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
        for (All alls : all2)
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
        for (All alls : all2)
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
        for (All alls : all2)
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

    @FXML
    void initialize() {
        all = new ArrayList<>();
        try {
            all.addAll(Serializator.deserialization());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка ввода-вывода\n");
        }
        System.out.println("afsgdhfjhgkjhgrsfa");
        all3.clear();
        all3.addAll(all);

        all2.clear();
        all2.addAll(all);
        showBiscuits();
    }
    public static double count() {
        User user = EntryController.getUser();
        Calculate result = ((n) -> {
            double w1 = 0;
            if (user.getPresent() == null)
                return 0;
            int size = user.getPresent().size();
            for (int i = 0; i < size; i++) {
                w1 += user.getPresent().get(i).getAllWeightPresent();
            }
            return w1;
        });

        if (result.func(user) == 0) {
          return 0;
        } else
           return result.func(user);
    }

}
