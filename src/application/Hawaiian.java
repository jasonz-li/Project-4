package application;

import java.util.ArrayList;

public class Hawaiian extends Pizza{

    Hawaiian(ArrayList<Topping> toppings, Size size) {
        super(toppings, size);
    }

    public double price() {
        double small = 10.99;
        double medium = small + 2;
        double large = medium + 2;
        int maxToppings = 7;
        int hawaiianToppings = 2;
        double toppingCost = 1.49;
        int numberOfToppings = toppings.size();
        int numExtraToppings = numberOfToppings - hawaiianToppings;

        if (size.equals(Size.small)) {
            if (numExtraToppings == 0){
                return small;
            }
            else{
                return small + (numberOfToppings * toppingCost);
            }
        }
        else if (size.equals(Size.medium)){
            if (numExtraToppings == 0){
                return medium;
            }
            else{
                return medium + (numberOfToppings * toppingCost);
            }
        }
        else if (size.equals(Size.large)){
            if (numExtraToppings == 0){
                return large;
            }
            else{
                return large + (numberOfToppings * toppingCost);
            }
        }
        return 0.00;
    }
}
