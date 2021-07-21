package CoffeeMachine;

public class CoffeeFactoryMain implements WelcomeInterface {

    public static void main(String[] args) {

        // Initialises the milk units and Bean units
        CoffeeFactoryParent.setAvailableBeanUnits(1);
        CoffeeFactoryParent.setAvailableMilkUnits(1);
        // Calls the inner class CoffeeMaps to set all values for required coffee amd milk units in the map
        //coffeeMapUnit
        CoffeeFactoryParent.CoffeeMaps.setAllCoffee();
        // Calls the WelcomeInterface.welcomePage()
        WelcomeInterface.welcomePage();


    }

}
