module com.example.laba5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba5 to javafx.fxml;
    exports com.example.laba5;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Controller.Admin;
    opens Controller.Admin to javafx.fxml;
    exports Controller.Admin.Menu;
    opens Controller.Admin.Menu to javafx.fxml;
    exports Controller.Admin.Users;
    opens Controller.Admin.Users to javafx.fxml;
}