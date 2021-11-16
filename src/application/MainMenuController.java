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
    ArrayList<Order> orders = new ArrayList<>();
    StoreOrders storeOrders = new StoreOrders(orders);

    @FXML
    void currentOrders(ActionEvent event) throws IOException {
        if(!alertCheck()) {
            return;
        }
        try {
            Order currentOrder = new Order(phoneNumber.getText(), pizzas);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("currentOrderView.fxml"));
            Parent root = (Parent) loader.load();
            CurrentOrderController currentController = loader.getController();
            currentController.setMainController(this);

            if (!orders.isEmpty()) {
                System.out.println(orders.get(0).getPizzas().isEmpty());
            }
            Order order = new Order(phoneNumber.getText(), pizzas);
            currentController.setOrder(order);
            currentController.displayOrder(currentOrder);
            currentController.reCalculateFields(currentOrder);

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
            if (orders.size() == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Incomplete Order Placement!");
                alert.setContentText("Please order at least 1 pizza!");
                alert.showAndWait();
                return;
            }


            FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrderView.fxml"));
            Parent root = (Parent) loader.load();
            StoreOrderController storeOrder = loader.getController();
            storeOrder.setMainController(this);

            System.out.println(orders.get(0).getPizzas().get(0).toppings);
            System.out.println(storeOrders.getOrders().get(0).getPhoneNum() + storeOrders.getOrders().get(0).getPizzas().get(0).toppings);
            storeOrder.setStoreOrder(storeOrders);
            storeOrder.setOrderPrice();
            storeOrder.initializeComboBox();

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
        if(!alertCheck()) {
            return;
        }
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
        if(!alertCheck()) {
            return;
        }
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
        if(!alertCheck()) {
            return;
        }
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

    public ArrayList<Order> getOrders(){
        return this.orders;
    }

    public static boolean isValid(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
    }

    private boolean alertCheck(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (phoneNumber.getText().isEmpty()){
            alert.setTitle("Empty Text Field");
            alert.setHeaderText("No phone number entered.");
            alert.setContentText("Phone number field cannot be empty.");
            alert.showAndWait();
            return false;
        }
        else{
            if (phoneNumber.getText().length() != 10){
                alert.setTitle("Invalid Phone Number");
                alert.setHeaderText("Invalid Phone Number");
                alert.setContentText("Please enter a valid phone number.");
                alert.showAndWait();
                return false;
            }
            else if (!isValid(phoneNumber.getText())){
                alert.setTitle("Invalid Phone Number");
                alert.setHeaderText("Invalid Phone Number");
                alert.setContentText("Please enter a valid phone number.");
                alert.showAndWait();
                return false;
            }
        }
        return true;
    }
}