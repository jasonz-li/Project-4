package application;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class StoreOrders {
    private ArrayList<Order> orders;

    public StoreOrders (ArrayList<Order> orders){
        this.orders = orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
    public void removeOrder(Order order){
        this.orders.remove(order);
    }


    /**
     * //idk yet?
     void exportFile(ActionEvent event) {
     FileChooser chooser = new FileChooser();
     chooser.setTitle("Open Target File for the Export");
     chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
     new FileChooser.ExtensionFilter("All Files", "*.*"));
     Stage stage = new Stage();
     File targeFile = chooser.showSaveDialog(stage); //get the reference of the target file
     //write code to write to the file.
     }
     */
}