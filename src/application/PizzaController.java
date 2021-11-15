package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Contains the functionality for PizzaView.fxml
 *
 * @author Jason Li
 */

public class PizzaController {

    /**
     * MainMenuController
     */
    private MainMenuController mainController;

    /**
     * Instance of a deluxe pizza
     */
    private Deluxe deluxe;

    /**
     * Instance of hawaiian pizza
     */
    private Hawaiian hawaiian;

    /**
     * Instance of pepperoni pizza
     */
    private Pepperoni pepperoni;

    /**
     * Instance of a DecimalFormat to reduce number of digits in the price text field
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");


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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (mainController.getPizzaType().equals("Deluxe")) {
            if (currentToppings.getItems().size() == 7) {
                alert.setTitle("Error");
                alert.setHeaderText("Too many toppings!");
                alert.setContentText("Number of toppings cannot exceed 7.");
                alert.showAndWait();
            }
            else if (additionalToppings.getSelectionModel().getSelectedItems() != null){
                ArrayList<Topping> selected = new ArrayList<Topping>(additionalToppings.getSelectionModel().getSelectedItems());
                currentToppings.getItems().addAll(selected);
                this.deluxe.toppings.addAll(selected);
                additionalToppings.getItems().removeAll(selected);
                price.setText("$" + df.format(this.deluxe.price()));
            }
            else{
                alert.setTitle("Error");
                alert.setHeaderText("No topping selected.");
                alert.setContentText("Must select a topping to add.");
                alert.showAndWait();
            }
        }
        else if (mainController.getPizzaType().equals("Hawaiian")){
            if (currentToppings.getItems().size() == 7) {
                alert.setTitle("Error");
                alert.setHeaderText("Too many toppings!");
                alert.setContentText("Number of toppings cannot exceed 7.");
                alert.showAndWait();
            }
            else if (additionalToppings.getSelectionModel().getSelectedItems() != null){
                ArrayList<Topping> selected = new ArrayList<Topping>(additionalToppings.getSelectionModel().getSelectedItems());
                currentToppings.getItems().addAll(selected);
                this.hawaiian.toppings.addAll(selected);
                additionalToppings.getItems().removeAll(selected);
                price.setText("$" + df.format(this.hawaiian.price()));
            }
            else{
                alert.setTitle("Error");
                alert.setHeaderText("No topping selected.");
                alert.setContentText("Must select a topping to add.");
                alert.showAndWait();
            }
        }
        else if (this.pepperoni != null){
            if (currentToppings.getItems().size() == 7) {
                alert.setTitle("Error");
                alert.setHeaderText("Too many toppings!");
                alert.setContentText("Number of toppings cannot exceed 7.");
                alert.showAndWait();
            }
            else if (additionalToppings.getSelectionModel().getSelectedItems() != null){
                ArrayList<Topping> selected = new ArrayList<Topping>(additionalToppings.getSelectionModel().getSelectedItems());
                currentToppings.getItems().addAll(selected);
                this.pepperoni.toppings.addAll(selected);
                additionalToppings.getItems().removeAll(selected);
                price.setText("$" + df.format(this.pepperoni.price()));
            }
            else{
                alert.setTitle("Error");
                alert.setHeaderText("No topping selected.");
                alert.setContentText("Must select a topping to add.");
                alert.showAndWait();
            }
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
                price.setText("$" + df.format(this.deluxe.price()));
            }
        }
        else if (this.hawaiian != null){
            if (currentToppings.getItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No Toppings to Remove!");
                alert.setContentText("Number of toppings cannot drop below 0");
                alert.showAndWait();
            } else {
                ArrayList<Topping> selected = new ArrayList<Topping>(currentToppings.getSelectionModel().getSelectedItems());
                additionalToppings.getItems().addAll(selected);
                this.hawaiian.toppings.removeAll(selected);
                currentToppings.getItems().removeAll(selected);
                price.setText("$" + df.format(this.hawaiian.price()));
            }
        }
        else if (this.pepperoni != null){
            if (currentToppings.getItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No Toppings to Remove!");
                alert.setContentText("Number of toppings cannot drop below 0");
                alert.showAndWait();
            } else {
                ArrayList<Topping> selected = new ArrayList<Topping>(currentToppings.getSelectionModel().getSelectedItems());
                additionalToppings.getItems().addAll(selected);
                this.pepperoni.toppings.removeAll(selected);
                currentToppings.getItems().removeAll(selected);
                price.setText("$" + df.format(this.pepperoni.price()));
            }
        }

    }

    @FXML
    void sizeChange(ActionEvent event) {
        if (this.deluxe != null) {
            this.deluxe.size = sizes.getValue();
            price.setText("$" + df.format(this.deluxe.price()));
        }
        else if (this.hawaiian != null){
            this.hawaiian.size = sizes.getValue();
            price.setText("$" + df.format(this.hawaiian.price()));
        }
        else if (this.pepperoni != null){
            this.pepperoni.size = sizes.getValue();
            price.setText("$" + df.format(this.pepperoni.price()));
        }
    }

    @FXML
    void addToOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pizza Added");
        alert.setHeaderText("Pizza customization complete!");
        alert.setContentText("Successfully added pizza!");
        if (this.deluxe != null){
            mainController.getPizzas().add(this.deluxe);
            alert.showAndWait();
            this.deluxe = null;
            Stage stage = (Stage) addToOrderButton.getScene().getWindow();
            stage.close();
        }
        else if (this.hawaiian != null){
            mainController.getPizzas().add(this.hawaiian);
            alert.showAndWait();
            this.hawaiian = null;
            Stage stage = (Stage) addToOrderButton.getScene().getWindow();
            stage.close();
        }
        else if (this.pepperoni != null){
            mainController.getPizzas().add(this.pepperoni);
            alert.showAndWait();
            this.pepperoni = null;
            Stage stage = (Stage) addToOrderButton.getScene().getWindow();
            stage.close();
        }
    }

    ////// Methods Section //////

    /**
     * Sets mainController to another controller.
     * @param controller Targeted controller
     */
    public void setMainController(MainMenuController controller) {
        mainController = controller;
    }


    /**
     * Sets the pizza and initializes the current and additional toppings.
     * @param pizzaType Type of pizza
     */
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
                this.hawaiian = new Hawaiian(mainController.getHawaiian().toppings, Size.small);
                currentToppings.setItems(FXCollections.observableArrayList(mainController.getHawaiian().toppings));
                additionalToppings.setItems(FXCollections.observableArrayList(Topping.Pepperoni, Topping.Sausage,
                        Topping.Onions, Topping.Mushrooms, Topping.Tomatoes, Topping.Olives, Topping.Peppers));

                break;
            case "Pepperoni":
                all.removeAll(FXCollections.observableArrayList(mainController.getPepperoni().toppings));
                this.pepperoni = new Pepperoni(mainController.getPepperoni().toppings, Size.small);
                currentToppings.setItems(FXCollections.observableArrayList(mainController.getPepperoni().toppings));
                additionalToppings.setItems(FXCollections.observableArrayList(Topping.Sausage, Topping.Onions, Topping.Mushrooms,
                        Topping.Tomatoes, Topping.Olives, Topping.Peppers, Topping.Pineapple, Topping.Ham));
                break;
        }
    }

    /**
     * Sets the combo box with options from the enum Size class.
     */
    public void setComboBox(){
        sizes.getItems().addAll(Size.small, Size.medium, Size.large);
        sizes.setValue(Size.small);
    }

    /**
     * Sets the price of the pizza for the price text field.
     * @param pizza Type of pizza
     */
    public void setPrice(String pizza){
        switch (pizza) {
            case "Deluxe":
                price.setText("$" + df.format(mainController.getDeluxe().price()));
                break;
            case "Hawaiian":
                price.setText("$" + df.format(mainController.getHawaiian().price()));
                break;
            case "Pepperoni":
                price.setText("$" + df.format(mainController.getPepperoni().price()));
                break;
        }
    }

    /**
     * Sets the pizza image.
     * @param pizza Type of pizza
     */
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