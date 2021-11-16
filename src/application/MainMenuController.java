package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for the home screen.
 *
 * @author John Leng, Jason Li
 */

public class MainMenuController {
    /**
     * Type of pizza
     */
    private String pizzaType;

    /**
     * Deluxe pizza
     */
    private Deluxe deluxe;

    /**
     * Hawaiian pizza
     */
    private Hawaiian hawaiian;

    /**
     * Pepperoni pizza
     */
    private Pepperoni pepperoni;


    @FXML
    private TextField phoneNumber;

    ArrayList<Pizza> pizzas = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<Order>();

    @FXML
    void currentOrders(ActionEvent event) throws IOException {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        if (phoneNumber.getText().isEmpty()){
            alert.setTitle("Empty Text Field");
            alert.setHeaderText("No phone number entered.");
            alert.setContentText("Phone number field cannot be empty.");
            alert.showAndWait();
            return;
        }
        else{
            if (phoneNumber.getText().length() != 10){
                alert.setTitle("Invalid Phone Number");
                alert.setHeaderText("Invalid Phone Number");
                alert.setContentText("Please enter a valid phone number.");
                alert.showAndWait();
                return;
            }
            else if (!isValid(phoneNumber.getText())){
                alert.setTitle("Invalid Phone Number");
                alert.setHeaderText("Invalid Phone Number");
                alert.setContentText("Please enter a valid phone number.");
                alert.showAndWait();
                return;
            }
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("currentOrderView.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Current Orders");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void storeOrders(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("storeOrderView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orderDeluxe(ActionEvent event) throws IOException {
        this.pizzaType = "Deluxe";
        this.deluxe = (Deluxe) PizzaMaker.createPizza(this.pizzaType);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaView.fxml"));
            Parent root = (Parent) loader.load();
            PizzaController pizzaView = loader.getController();
            pizzaView.setMainController(this);

            pizzaView.setPizza(this.pizzaType);
            pizzaView.setComboBox();
            pizzaView.setPrice(this.pizzaType);
            pizzaView.setPizzaImage(this.pizzaType);

            Stage stage = new Stage();
            stage.setTitle("Customize Your Pizza");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orderHawaiian(ActionEvent event) throws IOException {
        this.pizzaType = "Hawaiian";
        this.hawaiian = (Hawaiian) PizzaMaker.createPizza(this.pizzaType);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaView.fxml"));
            Parent root = (Parent) loader.load();
            PizzaController pizzaView = loader.getController();
            pizzaView.setMainController(this);

            pizzaView.setPizza(this.pizzaType);
            pizzaView.setComboBox();
            pizzaView.setPrice(this.pizzaType);
            pizzaView.setPizzaImage(this.pizzaType);

            Stage stage = new Stage();
            stage.setTitle("Customize Your Pizza");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orderPepperoni(ActionEvent event) throws IOException{
        this.pizzaType = "Pepperoni";
        this.pepperoni = (Pepperoni) PizzaMaker.createPizza(this.pizzaType);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaView.fxml"));
            Parent root = (Parent) loader.load();
            PizzaController pizzaView = loader.getController();
            pizzaView.setMainController(this);

            pizzaView.setPizza(this.pizzaType);
            pizzaView.setComboBox();
            pizzaView.setPrice(this.pizzaType);
            pizzaView.setPizzaImage(this.pizzaType);

            Stage stage = new Stage();
            stage.setTitle("Customize Your Pizza");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    ////// Methods Section //////

    /**
     * Retreives type of pizza as a string
     * @return type of pizza
     */
    public String getPizzaType(){
        return this.pizzaType;
    }

    /**
     * Retrieves deluxe pizza
     * @return deluxe pizza
     */
    public Deluxe getDeluxe(){
        return this.deluxe;
    }

    /**
     * Retrieves hawaiian pizza
     * @return hawaiian pizza
     */
    public Hawaiian getHawaiian(){
        return this.hawaiian;
    }

    /**
     * Retrieves pepperoni pizza
     * @return pepperoni pizza
     */
    public Pepperoni getPepperoni(){
        return this.pepperoni;
    }

    /**
     * Retrieves the ArrayList of pizzas
     * @return ArrayList of pizzas
     */
    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    public static boolean isValid(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
    }
}
