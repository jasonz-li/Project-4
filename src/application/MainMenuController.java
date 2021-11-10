package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainMenuController {

    ArrayList<Order> orders = new ArrayList<Order>();

    @FXML
    private TextField phoneNumber;




    @FXML
    void currentOrders(ActionEvent event) throws IOException {
        BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("currentOrderView.fxml"));
    }

    @FXML
    void orderDeluxe(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PizzaView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Pizza Order");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orderHawaiian(ActionEvent event) {

    }

    @FXML
    void orderPepperoni(ActionEvent event) {

    }

    @FXML
    void storeOrders(ActionEvent event) {

    }

}
