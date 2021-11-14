package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

    @FXML
    void placeOrder(ActionEvent event) {

    }

    @FXML
    void removePizza(ActionEvent event) {



        reCalculateFields(OrderObject);
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
        Formatter formatter = new Formatter();
        formatter.format("%.2f", price);
        formatter.format("%.2f", taxAmount);
        formatter.format("%.2f", total);
        subtotalField.setText(String.valueOf(price));
        salesTaxField.setText(String.valueOf(taxAmount));
        orderTotal.setText(String.valueOf(total));
    }

    public void displayOrder(Order order){
        for(int i = 0; i < order.getPizzasArray().size(); i++){
            listView.getItems().add(order.getPizzasArray().get(i));
        }
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