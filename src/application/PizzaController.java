package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;

public class PizzaController {
    private MainMenuController mainController;
    private Deluxe deluxe;
    private Hawaiian hawaiian;
    private Pepperoni pepperoni;

    @FXML
    private Button addToOrderButton;

    @FXML
    private ListView<Topping> additionalToppings;

    @FXML
    private ListView<Topping> currentToppings;

    @FXML
    private ImageView pizzaImage;

    @FXML
    private TextField price;

    @FXML
    private Button remove;

    @FXML
    private ComboBox<Size> sizes = new ComboBox<>();

    @FXML
    void add(ActionEvent event) {
        if (this.deluxe != null) {
            if (currentToppings.getItems().size() == 7) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Too many toppings!");
                alert.setContentText("Number of toppings cannot exceed 7.");
                alert.showAndWait();
            } else {
                ArrayList<Topping> selected = new ArrayList<Topping>(additionalToppings.getSelectionModel().getSelectedItems());
                currentToppings.getItems().addAll(selected);
                this.deluxe.toppings.addAll(selected);
                additionalToppings.getItems().removeAll(selected);
                price.setText(String.valueOf("$" + this.deluxe.price()));
            }
        }
        else if (this.hawaiian != null){

        }
        else if (this.pepperoni != null){

        }
    }

    @FXML
    void remove(ActionEvent event) {
        if (this.deluxe != null) {
            if (currentToppings.getItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No Toppings to Remove!");
                alert.setContentText("Number of toppings cannot drop below 0");
                alert.showAndWait();
            } else {
                ArrayList<Topping> selected = new ArrayList<Topping>(currentToppings.getSelectionModel().getSelectedItems());
                additionalToppings.getItems().addAll(selected);
                this.deluxe.toppings.removeAll(selected);
                currentToppings.getItems().removeAll(selected);
                price.setText("$" + this.deluxe.price());
            }
        }
        else if (this.hawaiian != null){

        }
        else if (this.pepperoni != null){

        }

    }

    @FXML
    void sizeChange(ActionEvent event) {
        if (this.deluxe != null) {
            this.deluxe.size = sizes.getValue();
            price.setText("$" + this.deluxe.price());
        }
        else if (this.hawaiian != null){

        }
        else if (this.pepperoni != null){

        }
    }

    @FXML
    void addToOrder(ActionEvent event) {
        mainController.
    }

    ///////////////////////////////////

    public void setMainController(MainMenuController controller) {
        mainController = controller;
    }


    public void setPizza(String pizzaType){
        ArrayList<Topping> all = new ArrayList<Topping>();
        all.add(Topping.Sausage);
        all.add(Topping.Pepperoni);
        all.add(Topping.Pineapple);
        all.add(Topping.Ham);
        all.add(Topping.Tomatoes);
        all.add(Topping.Olives);
        all.add(Topping.Onions);
        all.add(Topping.Peppers);
        all.add(Topping.Mushrooms);
        switch (pizzaType) {
            case "Deluxe":
                all.removeAll(FXCollections.observableArrayList(mainController.getDeluxe().toppings));
                this.deluxe = new Deluxe(mainController.getDeluxe().toppings, Size.small);
                currentToppings.setItems(FXCollections.observableArrayList(this.deluxe.toppings));
                additionalToppings.setItems(FXCollections.observableArrayList(all));
                break;
            case "Hawaiian":
                all.removeAll(FXCollections.observableArrayList(mainController.getHawaiian().toppings));
                currentToppings.setItems(FXCollections.observableArrayList(mainController.getHawaiian().toppings));
                additionalToppings.setItems(FXCollections.observableArrayList(Topping.Pepperoni, Topping.Sausage,
                        Topping.Onions, Topping.Mushrooms, Topping.Tomatoes, Topping.Olives, Topping.Peppers));

                break;
            case "Pepperoni":
                all.removeAll(FXCollections.observableArrayList(mainController.getPepperoni().toppings));
                currentToppings.setItems(FXCollections.observableArrayList(mainController.getPepperoni().toppings));
                additionalToppings.setItems(FXCollections.observableArrayList(Topping.Sausage, Topping.Onions, Topping.Mushrooms,
                        Topping.Tomatoes, Topping.Olives, Topping.Peppers, Topping.Pineapple, Topping.Ham));
                break;
        }
    }

    public void setComboBox(){
        sizes.getItems().addAll(Size.small, Size.medium, Size.large);
        sizes.setValue(Size.small);
    }

    public void setPrice(String pizza){
        switch (pizza) {
            case "Deluxe":
                price.setText("$" + mainController.getDeluxe().price());
                break;
            case "Hawaiian":
                price.setText("$" + mainController.getHawaiian().price());
                break;
            case "Pepperoni":
                price.setText("$" + mainController.getPepperoni().price());
                break;
        }
    }

    public void setPizzaImage(String pizza){
        File file;
        Image image;
        switch (pizza) {
            case "Deluxe":
                file = new File("src/application/deluxePizza.jpg");
                image = new Image(file.toURI().toString());
                pizzaImage.setImage(image);
                break;
            case "Hawaiian":
                file = new File("src/application/hawaiianPizza.jpg");
                image = new Image(file.toURI().toString());
                pizzaImage.setImage(image);
                break;
            case "Pepperoni":
                file = new File("src/application/pepperoniPizza.jpg");
                image = new Image(file.toURI().toString());
                pizzaImage.setImage(image);
                break;
        }
    }


}