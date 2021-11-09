package application;

import java.util.ArrayList;

public class Order {
    private String phoneNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public Order(String phoneNumber, ArrayList<Pizza> pizzas){
        if (phoneNumber.length() == 10){
            String number = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
            this.phoneNumber = number;
            this.pizzas = pizzas;
        }
        else {
            this.phoneNumber = phoneNumber;
            this.pizzas = pizzas;
        }
    }

}


