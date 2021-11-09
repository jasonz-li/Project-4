package application;

//create an instance of subclasses based on the chosen flavor


import java.util.ArrayList;

public class PizzaMaker {
    public static Pizza createPizza(String flavor) {
        ArrayList<Topping> toppings = new ArrayList<Topping>();
        Size small = Size.small;
        switch (flavor){
            case "Deluxe":
                toppings.add(Topping.Sausage);
                toppings.add(Topping.Peppers);
                toppings.add(Topping.Mushrooms);
                toppings.add(Topping.Onions);
                toppings.add(Topping.Beef);
                Deluxe deluxe = new Deluxe (toppings, small);
                return deluxe;

            case "Hawaiian":
                toppings.add(Topping.Pineapple);
                toppings.add(Topping.Ham);
                Hawaiian hawaiian = new Hawaiian(toppings, small);
                return hawaiian;

            case "Pepperoni":
                toppings.add(Topping.Pepperoni);
                Pepperoni pepperoni = new Pepperoni(toppings, small);
                return pepperoni;
        }
        return null;
    }
}