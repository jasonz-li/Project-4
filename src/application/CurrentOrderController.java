package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    @FXML
    private TextField customerNumber;

    @FXML
    private ListView<?> listView;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button removePizzaButton;

    @FXML
    private TextField salesTaxField;

    @FXML
    private TextField subtotalField;

    @FXML
    void placeOrder(ActionEvent event) {

    }

    @FXML
    void removePizza(ActionEvent event) {

    }

}