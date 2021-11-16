package application;

import java.util.ArrayList;

public class Order {
    private String phoneNumber;
    private ArrayList<Pizza> pizzas;

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

    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public void deletePizza(Pizza pizza){
        this.pizzas.remove(pizza);
    }

    public String getPhoneNum(){
        return this.phoneNumber;
    }

    public ArrayList<Pizza> getPizzasArray(){
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


