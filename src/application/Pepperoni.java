package application;

import java.util.ArrayList;

/**
 * Subclass of pizza for a pepperoni style pizza
 *
 * @author Jason Li, John Leng
 */

public class Pepperoni extends Pizza{

    /**
     * Initializes a pepperoni pizza
     * @param toppings ArrayList of toppings
     * @param size Size of pizza
     */
    Pepperoni(ArrayList<Topping> toppings, Size size) {
        super(toppings, size);
    }

    /**
     * Calculates price of a pepperoni pizza
     * @return Price of pepperoni pizza
     */
    public double price(){
        double small = 8.99;
        double medium = small + 2;
        double large = medium + 2;
        int pepperoniToppings = 1;
        double toppingCost = 1.49;
        int numberOfToppings = toppings.size();
        int numExtraToppings = numberOfToppings - pepperoniToppings;

        if (size.equals(Size.small)) {
            if (numberOfToppings < pepperoniToppings){
                return small;
            }
            else{
                return small + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.medium)){
            if (numberOfToppings < pepperoniToppings){
                return medium;
            }
            else{
                return medium + (numExtraToppings * toppingCost);
            }
        }
        else if (size.equals(Size.large)){
            if (numberOfToppings < pepperoniToppings){
                return large;
            }
            else{
                return large + (numExtraToppings * toppingCost);
            }
        }
        return 0.00;
    }
}
