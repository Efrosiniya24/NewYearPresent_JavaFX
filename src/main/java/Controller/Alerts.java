package Controller;

import com.example.laba5.NewYearApplication;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Objects;

import static com.example.laba5.NewYearApplication.image;

public class Alerts {
    private static final String WARNING= "com/example/laba5/warning.png";

//    public static void warningAlert(String message) {
//
//        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
//        alert.setTitle("Предупреждение");
//
//        Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(image);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }

    public static void warningAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(48);
        imageView.setFitWidth(48);
        String imagePath = "warning.png";
        Image image = new Image(Objects.requireNonNull(NewYearApplication.class.getResourceAsStream(imagePath)));
        Stage stage=(Stage) alert.getDialogPane().getScene().getWindow();stage.getIcons().add(image);
        alert.setGraphic(imageView);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}

