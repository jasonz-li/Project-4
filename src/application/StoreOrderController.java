
package application;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.ArrayList;

public class StoreOrderController {

    @FXML
    private Button cancelStoreOrderButton;

    @FXML
    private TextField entireOrderTotal;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private ListView<Order> orderListView;

    @FXML
    private TextArea pizzaTextArea;

    private StoreOrders storeOrder;

    @FXML
    void exportStoreOrders(ActionEvent event) {

    }

    @FXML
    void cancelStoreOrder(ActionEvent event) {
        storeOrder.removeOrder(orderListView.getSelectionModel().getSelectedItem());

        displayOrdersList();
        setOrderPrice();
    }

    public void initialize(){
        orderListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Order> ov, Order old_val, Order new_val) -> {
            if(new_val != null) {
                Order selectedItem = orderListView.getSelectionModel().getSelectedItem();
                displayPizzas(selectedItem);
                setOrderPrice();
            }
        });
    }

    public void displayOrdersList() {
        orderListView.getItems().clear();

        for (int i = 0; i < storeOrder.getOrders().size(); i++) {
            orderListView.getItems().add(storeOrder.getOrders().get(i));
        }

        orderListView.setCellFactory(new Callback<ListView<Order>, ListCell<Order>>() {

            @Override
            public ListCell<Order> call(ListView<Order> param) {
                ListCell<Order> cell = new ListCell<Order>() {
                    @Override
                    protected void updateItem(Order order, boolean bln) {
                        super.updateItem(order, bln);
                        if (order != null) {
                            setText(order.getPhoneNumber());
                        }
                    }
                };
                return cell;
            }
        });
    }

    public void displayPizzas(Order order) {
        pizzaTextArea.clear();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < order.getPizzasArray().size(); i++) {
            output.append(order.singlePizzaToString(order.getPizzasArray().get(i))).append("\n");
        }
        pizzaTextArea.setText(output.toString());
    }


    public void setOrderPrice(){
        double price = 0;
        double taxAmount = 0;
        double total = 0;
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

    public void setUpStoreOrder(ArrayList<Order> orders){
        this.storeOrder = new StoreOrders(orders);
    }
}

