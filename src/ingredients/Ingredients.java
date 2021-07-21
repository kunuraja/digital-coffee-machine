package ingredients;

import CoffeeMachine.CoffeeFactoryParent;

// Interface to have common methods for addition of ingredients
public interface Ingredients {

    default int addMilk(int ltrsToAdd) {
        return 0;
    }

    static int checkMilkTankCapacity() {

        return CoffeeFactoryParent.milkTankCapacity;
    }

    default int addCoffee(int unitsToAdd) {
        return 0;
    }

    static int checkCoffeeBeanCapacity() {

        return CoffeeFactoryParent.coffeeBeanTankCapacity;
    }


}
