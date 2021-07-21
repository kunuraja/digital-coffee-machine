package advancedCoffee;


import CoffeeMachine.*;
import ingredients.Ingredients;
import standardCoffee.StandardCoffee;

public class AdvancedFactory extends AbstractCoffeeFactory {

    public static int coffeeChoice;


    @Override
    public Ingredients getIngredients(int choice) {
        return null;
    }

    @Override
    public StandardCoffee getStandard(int choice) {
        return null;
    }

    // Overridden getAdvanced() which returns Advanced type object ( Long Black / Filter Coffee)
    @Override
    public AdvancedCoffee getAdvanced(int choice) {
        coffeeChoice = choice;

        if (choice == 4) {
            return new LongBlack();
        } else if (choice == 5) {
            return new FilterCoffee();
        } else
            return null;


    }
}
