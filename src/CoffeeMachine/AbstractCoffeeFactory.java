package CoffeeMachine;

import advancedCoffee.AdvancedCoffee;
import ingredients.Ingredients;
import standardCoffee.StandardCoffee;

public abstract class AbstractCoffeeFactory {


    // Ingredients interface type method to return any Ingredient type object (Milk / Coffee)
    public abstract Ingredients getIngredients(int choice);

    // Standard interface type method to return any Standard type object (Latte / Cappuccino / Espresso)
    public abstract StandardCoffee getStandard(int choice);

    // Advanced interface type method to return any Advanced type object (Long Black / Filter Coffee)
    public abstract AdvancedCoffee getAdvanced(int choice);


}
