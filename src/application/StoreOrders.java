package application;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class StoreOrders {
    private ArrayList<Order> orders;


    StoreOrders (ArrayList<Order> orders){
        this.orders = orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
    public void removeOrder(Order order){
        this.orders.remove(order);
    }

    public ArrayList<Order> getOrders(){
        return this.orders;
    }

}