package standardCoffee;

import CoffeeMachine.AbstractCoffeeFactory;
import ingredients.Ingredients;
import advancedCoffee.AdvancedCoffee;

public class StandardFactory extends AbstractCoffeeFactory {

    public static int coffeechoice;


    @Override
    public Ingredients getIngredients(int choice) {
        return null;
    }

    // Overridden getStandard() Method to select the type of standard coffee
    @Override
    public StandardCoffee getStandard(int choice) {
        coffeechoice = choice;

        if (choice == 1) {
            return new Latte();
        } else if (choice == 2) {
            return new Espresso();
        } else if (choice == 3) {
            return new Cappuccino();
        } else
            return null;


    }


    @Override
    public AdvancedCoffee getAdvanced(int choice) {
        return null;
    }
}
