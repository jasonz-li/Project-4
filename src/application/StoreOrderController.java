package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class StoreOrderController {

    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private Button cancelStoreOrderButton;

    @FXML
    private TextField entireOrderTotal;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private ListView<String> pizzaTextArea;

    private StoreOrders storeOrder;
    private MainMenuController mainController;

    @FXML
    void ComboBoxAction(ActionEvent event) {
        ComboBox.getItems().clear();
        String current = ComboBox.getSelectionModel().getSelectedItem();
        for (int i = 0; i < storeOrder.getOrders().size(); i++){
            if (storeOrder.getOrders().get(i).getPhoneNum().equals(current)){
                pizzaTextArea.getItems().addAll(FXCollections.observableArrayList(this.storeOrder.getOrders().get(i).singlePizzaToString(this.storeOrder.getOrders().get(i).getPizzas().get(i))));
            }
        }
    }

    @FXML
    void exportStoreOrders(ActionEvent event) {

    }

    @FXML
    void cancelStoreOrder(ActionEvent event) {
        String current = ComboBox.getSelectionModel().getSelectedItem();
        for (int i = 0; i < storeOrder.getOrders().size(); i++){
            if (storeOrder.getOrders().get(i).getPhoneNum().equals(current)){
                storeOrder.removeOrder(storeOrder.getOrders().get(i));
            }
        }
        initializeComboBox();
        setOrderPrice();
    }


    public void initializeComboBox(){
        ComboBox.getItems().clear();
        for (int i = 0; i < storeOrder.getOrders().size(); i++) {
            ComboBox.getItems().add(storeOrder.getOrders().get(i).getPhoneNum());
        }
    }

    public void setOrderPrice(){
        double price = 0;
        double taxAmount;
        double total;
        double taxPercent = 0.06625;
        for(int j = 0; j < storeOrder.getOrders().size(); j++) {
            Order OrderObject = storeOrder.getOrders().get(j);
            for (int i = 0; i < OrderObject.getPizzas().size(); i++) {
                if (OrderObject.getPizzas().get(i) instanceof Deluxe) {
                    Deluxe newDeluxe = (Deluxe) OrderObject.getPizzas().get(i);
                    price = price + newDeluxe.price();

                } else if (OrderObject.getPizzas().get(i) instanceof Hawaiian) {
                    Hawaiian newHaw = (Hawaiian) OrderObject.getPizzas().get(i);
                    price = price + newHaw.price();

                } else if (OrderObject.getPizzas().get(i) instanceof Pepperoni) {
                    Pepperoni newPep = (Pepperoni) OrderObject.getPizzas().get(i);
                    price = price + newPep.price();
                }
            }
        }
        taxAmount = price * taxPercent;
        total = taxAmount + price;
        entireOrderTotal.setText(String.valueOf(String.format("%.2f", total)));
    }

    public void setStoreOrder(StoreOrders orders){
        this.storeOrder = orders;
    }

    public void setMainController(MainMenuController mainMenuController) {
        this.mainController = mainMenuController;
    }
}
