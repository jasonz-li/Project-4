package application;

import java.util.ArrayList;

/**
 * Creates an instance of subclasses based on the chosen flavor.
 *
 * @author John Leng, Jason Li
 */

public class PizzaMaker {
    /**
     *  Creates an instance of subclasses based on the chosen flavor.
     * @param flavor Pizza flavor
     * @return pizza
     */
    public static Pizza createPizza(String flavor) {
        ArrayList<Topping> toppings = new ArrayList<Topping>();
        Size small = Size.small;
        switch (flavor) {
            case "Deluxe":
                toppings.add(Topping.Tomatoes);
                toppings.add(Topping.Peppers);
                toppings.add(Topping.Mushrooms);
                toppings.add(Topping.Onions);
                toppings.add(Topping.Olives);
                Deluxe deluxe = new Deluxe(toppings, small);
                return deluxe;
            case "Hawaiian":
                toppings.add(Topping.Pineapple);
                toppings.add(Topping.Ham);
                return new Hawaiian(toppings, small);
            case "Pepperoni":
                toppings.add(Topping.Pepperoni);
                return new Pepperoni(toppings, small);
            default:
                return new Deluxe(toppings, small); // Returns plain deluxe pizza as base case.
        }
    }
}