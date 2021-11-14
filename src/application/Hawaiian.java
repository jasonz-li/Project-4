package application;

import java.util.ArrayList;

/**
 * Subclass of pizza for a Hawaiian style pizza
 *
 * @author Jason LI, John Leng
 */

public class Hawaiian extends Pizza{

    /**
     * Initializes a hawaiian pizza
     * @param toppings ArrayList of toppings
     * @param size Size of pizza
     */
    Hawaiian(ArrayList<Topping> toppings, Size size) {
        super(toppings, size);
    }

    /**
     * Calculates the price of a hawaiian pizza
     * @return Price of hawaiian pizza
     */
    public double price() {
        double small = 10.99;
        double medium = small + 2;
        double large = medium + 2;
        int hawaiianToppings = 2;
        double toppingCost = 1.49;
        int numberOfToppings = toppings.size();
        int numExtraToppings = numberOfToppings - hawaiianToppings;

        if (size.equals(Size.small)) {
            if (numberOfToppings < hawaiianToppings){
                return small;
            }
            else{
                return small + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.medium)){
            if (numberOfToppings < hawaiianToppings){
                return medium;
            }
            else{
                return medium + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.large)){
            if (numberOfToppings < hawaiianToppings){
                return large;
            }
            else{
                return large + (numExtraToppings * toppingCost);
            }
        }
        return 0.00;
    }
}
