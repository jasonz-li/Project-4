package application;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;
    public abstract double price();

    public Pizza(ArrayList<Topping> toppings, Size size) {
        this.toppings = toppings;
    }
}

