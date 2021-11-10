package application;

import java.util.ArrayList;

public class Pepperoni extends Pizza{


    Pepperoni(ArrayList<Topping> toppings, Size size) {
        super(toppings, size);
    }

    public double price(){
        double small = 8.99;
        double medium = small + 2;
        double large = medium + 2;
        int maxToppings = 7;
        int pepperoniToppings = 1;
        double toppingCost = 1.49;
        int numberOfToppings = toppings.size();
        int numExtraToppings = numberOfToppings - pepperoniToppings;

        if (size.equals(Size.small)) {
            if (numExtraToppings == 0){
                return small;
            }
            else{
                return small + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.medium)){
            if (numExtraToppings == 0){
                return medium;
            }
            else{
                return medium + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.large)){
            if (numExtraToppings == 0){
                return large;
            }
            else{
                return large + (numExtraToppings * toppingCost);
            }
        }
        return 0.00;
    }
}
