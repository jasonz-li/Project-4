package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Formatter;

public class CurrentOrderController {

    @FXML
    private TextField customerNumber;

    @FXML
    private ListView<Pizza> listView;

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

    /**
     * MainMenuController
     */
    private MainMenuController mainController;

    private Order OrderObject;


    @FXML
    void placeOrder(ActionEvent event) {
        if(this.OrderObject.getPizzasArray().size() > 0){
            mainController.orders.add(OrderObject);

            mainController.getPizzas().clear();
            customerNumber.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Added");
            alert.setHeaderText("Order customization complete!");
            alert.setContentText("Successfully added order!");
            alert.showAndWait();

            Stage stage = (Stage) placeOrderButton.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Not Added");
            alert.setHeaderText("Order Incomplete!");
            alert.setContentText("Please add at least 1 pizza! ");
            alert.showAndWait();

            Stage stage = (Stage) placeOrderButton.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    void removePizza(ActionEvent event) {
        OrderObject.deletePizza(listView.getSelectionModel().getSelectedItem());

        reCalculateFields(OrderObject);
        displayOrder(OrderObject);
    }


    public void reCalculateFields(Order OrderObject){
        double price = 0;
        double taxAmount = 0;
        double total = 0;
        double taxPercent = 0.06625;
        for(int i = 0; i < OrderObject.getPizzasArray().size(); i++){
            if(OrderObject.getPizzasArray().get(i) instanceof Deluxe){
                Deluxe newDeluxe = (Deluxe) OrderObject.getPizzasArray().get(i);
                price = price + newDeluxe.price();

            }else if (OrderObject.getPizzasArray().get(i) instanceof Hawaiian){
                Hawaiian newHaw = (Hawaiian) OrderObject.getPizzasArray().get(i);
                price = price + newHaw.price();

            }else if (OrderObject.getPizzasArray().get(i) instanceof Pepperoni){
                Pepperoni newPep = (Pepperoni) OrderObject.getPizzasArray().get(i);
                price = price + newPep.price();
            }
        }
        taxAmount = price * taxPercent;
        total = taxAmount + price;
        subtotalField.setText(String.valueOf(String.format("%.2f", price)));
        salesTaxField.setText(String.valueOf(String.format("%.2f", taxAmount)));
        orderTotal.setText(String.valueOf(String.format("%.2f", total)));
    }

    public void displayOrder(Order order) {
        listView.getItems().clear();

        for (int i = 0; i < order.getPizzasArray().size(); i++) {
            listView.getItems().add(order.getPizzasArray().get(i));
        }

        listView.setCellFactory(new Callback<ListView<Pizza>, ListCell<Pizza>>() {

            @Override
            public ListCell<Pizza> call(ListView<Pizza> p) {
                ListCell<Pizza> cell = new ListCell<Pizza>() {
                    @Override
                    protected void updateItem(Pizza pizza, boolean bln) {
                        super.updateItem(pizza, bln);
                        if (pizza != null) {
                            setText(order.singlePizzaToString(pizza));
                        }
                    }
                };
                return cell;
            }
        });
    }

    /**
     * Sets mainController to another controller.
     * @param controller Targeted controller
     */
    public void setMainController(MainMenuController controller) {
        mainController = controller;
    }

    public void setNumber(String number){
        customerNumber.setText(number);
    }


    public void setOrderObject(Order order){
        this.OrderObject = order;
    }






    /**
     * code to print out things to listview:  (function in controller)
     * 1.Make toString method in Pizza
     * 2.When order is called, take order and loop over pizzas, tostring and output as listview, somehow
     * correlate pizza objects or pass them into listview to aid in deleting:
     *
     * on delete: recalculate and redisplay.
     */

}