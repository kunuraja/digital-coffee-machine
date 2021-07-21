package ingredients;

import CoffeeMachine.AbstractCoffeeFactory;
import advancedCoffee.AdvancedCoffee;
import standardCoffee.StandardCoffee;

public class IngredFactory extends AbstractCoffeeFactory {

    static int ingredChoice;


    // Overridden method from AbstractCoffeeFactory to select the choice for ingredients to add (Milk / Coffee Beans)
    @Override
    public Ingredients getIngredients(int choice) {
        ingredChoice = choice;
        if (choice == 1)
            return new Milk();
        else if (choice == 2)
            return new CoffeeBeans();


        return null;
    }

    @Override
    public StandardCoffee getStandard(int choice) {
        return null;
    }

    @Override
    public AdvancedCoffee getAdvanced(int choice) {
        return null;
    }
}
