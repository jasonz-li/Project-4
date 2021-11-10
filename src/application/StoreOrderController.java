package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class StoreOrderController {

    @FXML
    private Button cancelStoreOrderButton;

    @FXML
    private TextField entireOrderTotal;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private MenuButton menuButton;

    @FXML
    private ListView<?> storeOrderList;

    @FXML
    void cancelStoreOrder(ActionEvent event) {

    }

    @FXML
    void exportStoreOrders(ActionEvent event) {

    }

}