package application;

import org.junit.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class HawaiianTest {

    @Test
    public void price() {

        // Pepperoni, Pineapple, Ham, Tomatoes, Onions, Mushrooms, Peppers, Sausage, Olives


        // Ham, Pineapple, Small
        ArrayList<Topping> toppings = new ArrayList<Topping>();
        toppings.add(Topping.Ham);
        toppings.add(Topping.Pineapple);
        Size size = Size.small;
        Hawaiian hawaiianPizza = new Hawaiian(toppings, size);

        assertEquals(10.99, hawaiianPizza.price(), 0.05);



        // Ham, Pineapple, Medium
        ArrayList<Topping> toppings1 = new ArrayList<Topping>();
        toppings1.add(Topping.Ham);
        toppings1.add(Topping.Pineapple);
        Size size1 = Size.medium;

        Hawaiian hawaiianPizza1 = new Hawaiian(toppings1, size1);

        assertEquals(12.99, hawaiianPizza1.price(), 0.5);



        // 7 toppings, medium

        ArrayList<Topping> toppings2 = new ArrayList<Topping>();
        toppings2.add(Topping.Ham);
        toppings2.add(Topping.Pineapple);
        toppings2.add(Topping.Pepperoni);
        toppings2.add(Topping.Onions);
        toppings2.add(Topping.Mushrooms);
        toppings2.add(Topping.Peppers);
        toppings2.add(Topping.Tomatoes);

        Size size2 = Size.medium;

        Hawaiian hawaiianPizza2 = new Hawaiian(toppings2, size2);

        assertEquals(20.44, hawaiianPizza2.price(), 0.5);




        // 7 toppings, Large
        ArrayList<Topping> toppings3 = new ArrayList<Topping>();
        toppings3.add(Topping.Ham);
        toppings3.add(Topping.Pineapple);
        toppings3.add(Topping.Pepperoni);
        toppings3.add(Topping.Onions);
        toppings3.add(Topping.Mushrooms);
        toppings3.add(Topping.Peppers);
        toppings3.add(Topping.Tomatoes);
        Size size3 = Size.large;

        Hawaiian hawaiianPizza3 = new Hawaiian(toppings3, size3);

        assertEquals(22.44, hawaiianPizza3.price(), 0.5);



        //no toppings, small
        ArrayList<Topping> toppings4 = new ArrayList<Topping>();
        Size size4 = Size.small;

        Hawaiian hawaiianPizza4 = new Hawaiian(toppings4, size4);

        assertEquals(10.99, hawaiianPizza4.price(), 0.5);


        //no toppings, large
        ArrayList<Topping> toppings5 = new ArrayList<Topping>();
        Size size5 = Size.large;

        Hawaiian hawaiianPizza5 = new Hawaiian(toppings5, size5);

        assertEquals(14.99, hawaiianPizza5.price(), 0.5);



        // 3 toppings, large
        ArrayList<Topping> toppings6 = new ArrayList<Topping>();
        toppings6.add(Topping.Olives);
        toppings6.add(Topping.Onions);
        toppings6.add(Topping.Sausage);
        Size size6 = Size.large;

        Hawaiian hawaiianPizza6 = new Hawaiian(toppings6, size6);

        assertEquals(16.48, hawaiianPizza6.price(), 0.5);




        //6 toppings, large
        ArrayList<Topping> toppings7 = new ArrayList<Topping>();
        toppings7.add(Topping.Olives);
        toppings7.add(Topping.Onions);
        toppings7.add(Topping.Sausage);
        toppings7.add(Topping.Mushrooms);
        toppings7.add(Topping.Pineapple);
        toppings7.add(Topping.Peppers);
        Size size7 = Size.large;

        Hawaiian hawaiianPizza7 = new Hawaiian(toppings7, size7);

        assertEquals(20.95, hawaiianPizza7.price(), 0.5);

    }

}

