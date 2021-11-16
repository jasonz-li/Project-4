package application;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Order {
    private String phoneNumber;
    private ArrayList<Pizza> pizzas;

    public Order(String phoneNumber, ArrayList<Pizza> pizzas){
        if (!MainMenuController.isValid(phoneNumber)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Phone Number");
            alert.setHeaderText("Invalid Phone Number");
            alert.setContentText("Please enter a valid phone number.");
            alert.showAndWait();
            return;
        }
        else {
            this.phoneNumber = phoneNumber;
            this.pizzas = pizzas;
        }
    }



    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public void deletePizza(Pizza pizza){
        this.pizzas.remove(pizza);
    }

    public String getPhoneNum(){
        return this.phoneNumber;
    }

    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    public String singlePizzaToString(Pizza pizza){
        String outputString = "";
        if(pizza instanceof Deluxe){
            outputString = outputString + "Deluxe pizza, ";

        }else if (pizza instanceof Hawaiian){
            outputString = outputString + "Hawaiian pizza, ";

        }else if (pizza instanceof Pepperoni){
            outputString = outputString + "Pepperoni pizza, ";

        }
        outputString = outputString + toppingString(pizza.toppings) + pizza.size.toString() + ", " + pizza.price();

        return outputString;
    }

    public String toppingString(ArrayList<Topping> toppings){
        String toppingStr = "";
        for(int i = 0; i < toppings.size(); i++){
            toppingStr = toppingStr + toppings.get(i).toString() + ", ";
        }
        return toppingStr;
    }
}

