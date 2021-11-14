package application;

import java.util.ArrayList;

/**
 * Contains information about toppings, size, and price of pizza
 *
 * @author Jason Li, John Leng
 */

public abstract class Pizza {
    /**
     * ArrayList of toppings
     */
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();

    /**
     * Size of pizza
     */
    protected Size size;

    /**
     * Calculates price of pizza
     * @return Price of pizza
     */
    public abstract double price();

    /**
     * Initializes a pizza
     * @param toppings ArrayList of toppings
     * @param size Size of pizza
     */
    public Pizza(ArrayList<Topping> toppings, Size size) {
        this.toppings = toppings;
        this.size = size;
    }
}

