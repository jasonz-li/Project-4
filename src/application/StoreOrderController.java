
package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.ArrayList;

public class StoreOrderController {

    @FXML
    private ComboBox<Order> ComboBox;

    @FXML
    private Button cancelStoreOrderButton;

    @FXML
    private TextField entireOrderTotal;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private TextArea pizzaTextArea;

    private StoreOrders storeOrder;

    @FXML
    void ComboBoxAction(ActionEvent event) {
        Order currentOrder = ComboBox.getSelectionModel().getSelectedItem();
        displayPizzas(currentOrder);
        pizzaTextArea.setText(Integer.toString(currentOrder.getPizzasArray().size()));
    }

    @FXML
    void exportStoreOrders(ActionEvent event) {

    }

    @FXML
    void cancelStoreOrder(ActionEvent event) {
        storeOrder.removeOrder(ComboBox.getSelectionModel().getSelectedItem());

        initializeComboBox();
        setOrderPrice();
    }


    public void initializeComboBox(){
        ComboBox.getItems().clear();
        for (int i = 0; i < storeOrder.getOrders().size(); i++) {
            ComboBox.getItems().add(storeOrder.getOrders().get(i));
        }

    }

    public void displayPizzas(Order order) {                //DEBUG
        pizzaTextArea.clear();

        StringBuilder output = new StringBuilder(order.getPhoneNum());
        output.append("\n");

        if(order.getPizzasArray().size() == 0 ){
            output.append("Zero Pizzas");
        }
        for (int i = 0; i < order.getPizzasArray().size(); i++) {
            output.append(order.singlePizzaToString(order.getPizzasArray().get(i))).append("\n");
        }
        pizzaTextArea.setText(output.toString());
    }


    public void setOrderPrice(){
        double price = 0;
        double taxAmount;
        double total;
        double taxPercent = 0.06625;
        for(int j = 0; j < storeOrder.getOrders().size(); j++) {
            Order OrderObject = storeOrder.getOrders().get(j);
            for (int i = 0; i < OrderObject.getPizzasArray().size(); i++) {
                if (OrderObject.getPizzasArray().get(i) instanceof Deluxe) {
                    Deluxe newDeluxe = (Deluxe) OrderObject.getPizzasArray().get(i);
                    price = price + newDeluxe.price();

                } else if (OrderObject.getPizzasArray().get(i) instanceof Hawaiian) {
                    Hawaiian newHaw = (Hawaiian) OrderObject.getPizzasArray().get(i);
                    price = price + newHaw.price();

                } else if (OrderObject.getPizzasArray().get(i) instanceof Pepperoni) {
                    Pepperoni newPep = (Pepperoni) OrderObject.getPizzasArray().get(i);
                    price = price + newPep.price();
                }
            }
        }
        taxAmount = price * taxPercent;
        total = taxAmount + price;
        entireOrderTotal.setText(String.valueOf(String.format("%.2f", total)));
    }

    public void setUpStoreOrder(StoreOrders orders){
        this.storeOrder = orders;
    }
}
