package application;

import java.util.ArrayList;

public class Deluxe extends Pizza{

    Deluxe(ArrayList<Topping> toppings, Size size) {
        super(toppings, size);
    }

    public double price() {
        double small = 12.99;
        double medium = small + 2;
        double large = medium + 2;
        int deluxeToppings = 5;
        double toppingCost = 1.49;
        int numberOfToppings = toppings.size();
        int numExtraToppings = numberOfToppings - deluxeToppings;

        if (size.equals(Size.small)) {
            if (numberOfToppings < deluxeToppings){
                return small;
            }
            else{
                return small + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.medium)){
            if (numberOfToppings < deluxeToppings){
                return medium;
            }
            else{
                return medium + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.large)){
            if (numberOfToppings < deluxeToppings){
                return large;
            }
            else{
                return large + (numExtraToppings * toppingCost);
            }
        }
        return 0.00;
    }
}
