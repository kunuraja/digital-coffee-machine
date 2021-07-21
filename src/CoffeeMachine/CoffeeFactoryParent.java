package CoffeeMachine;

import advancedCoffee.AdvancedFactory;
import ingredients.IngredFactory;
import standardCoffee.StandardFactory;

import java.util.HashMap;

public class CoffeeFactoryParent {


    public static int milkTankCapacity = 110; // Total Milk capacity of Coffee machine
    public static int coffeeBeanTankCapacity = 210; // Total Bean capacity of Coffee machine
    public static int availableBeanUnits; // Available coffee units after add/utilisation of required units while brewing
    public static int availableMilkUnits; // Available milk units after add/utilisation of required units while brewing

    // Method to set the required coffee bean units for brewing coffee
    public static void setAvailableBeanUnits(int availableBeanUnits) {
        CoffeeFactoryParent.availableBeanUnits = availableBeanUnits;
    }

    // Method to set the required milk units for brewing coffee
    public static void setAvailableMilkUnits(int availableMilkUnits) {
        CoffeeFactoryParent.availableMilkUnits = availableMilkUnits;
    }


    // Static inner class to map the coffee types with the required bean and Milk units
    public static class CoffeeMaps {
        // Hashmap to map all coffee with a certain key value
        static HashMap<Integer, CoffeeMaps> coffeeMapUnit = new HashMap<>();
        public String coffeeType; // Type of coffee
        public int milkUnits; // Mapped milk units
        public int beanUnits; // Mapped bean units


        // Constructor that allocates memory for coffee map units
        CoffeeMaps(String coffeeType, int milkUnits, int beanUnits) {
            this.coffeeType = coffeeType;
            this.milkUnits = milkUnits;
            this.beanUnits = beanUnits;

        }

        // Method which maps the cofee type object with their respective keys
        public static void setAllCoffee() {
            coffeeMapUnit.put(1, new CoffeeMaps("Latte", 3, 2));
            coffeeMapUnit.put(2, new CoffeeMaps("Espresso", 1, 4));
            coffeeMapUnit.put(3, new CoffeeMaps("Cappuccino", 4, 1));
            coffeeMapUnit.put(4, new CoffeeMaps("Long Black", 2, 5));
            coffeeMapUnit.put(5, new CoffeeMaps("Filter Coffee", 4, 3));

        }

    }

// AbstractCoffeeFactory type method to return the corresponding type object
// (StandardFactory / AdvancedFactory / IngredientsFactory)

    public AbstractCoffeeFactory selectType(int enteredChoice) {
        if (enteredChoice == 1) {
            return new StandardFactory();
        } else if (enteredChoice == 2) {
            return new AdvancedFactory();
        } else if (enteredChoice == 3) {
            return new IngredFactory();
        } else
            return null;
    }


}
