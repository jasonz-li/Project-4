package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class PizzaController {

    @FXML
    private Button addToOrder;

    @FXML
    private ListView<?> additionalToppings;

    @FXML
    private ListView<?> currentToppings;

    @FXML
    private ImageView pizzaImage;

    @FXML
    private TextField price;

    @FXML
    private Button remove;

    @FXML
    private ComboBox<?> sizes;

    @FXML
    void add(ActionEvent event) {

    }

}