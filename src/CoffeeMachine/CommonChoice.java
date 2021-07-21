package CoffeeMachine;

import advancedCoffee.AdvancedCoffee;
import ingredients.Ingredients;
import standardCoffee.StandardCoffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CommonChoice {

    //Predicate to test if there is sufficient Milk and Bean Units to brew coffee
    static Predicate<Boolean> p1 = (b1) -> b1 == true;
    //Consumer method reference to call addMoreOrMainMenu() in multiple areas for code re-usability
    static Consumer<Integer> commonAddMoreBlock = AddMore::addMoreOrMainMenu;


    static int choice = 0;
    static CoffeeFactoryParent coffeeFactoryParent = new CoffeeFactoryParent();

    // Method to select from various types of Standard coffee, Here enteredchoice is 1
    public static void getStandardChoice(int enteredchoice) {
        // Call selectType() which will return object of AbstractCoffeeFactory type
        AbstractCoffeeFactory abstractCoffeeFactory = coffeeFactoryParent.selectType(enteredchoice);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the choice for standard coffee: ");
        System.out.println("Available Standard coffee are :  ");
        // Return the available standard coffee types from map
        for (Map.Entry<Integer, CoffeeFactoryParent.CoffeeMaps> map1 : CoffeeFactoryParent.CoffeeMaps.coffeeMapUnit.entrySet()) {
            if (map1.getKey() == 1 || map1.getKey() == 2 || map1.getKey() == 3)
                System.out.println(map1.getKey() + "  " + map1.getValue().coffeeType);

        }


        try {
            choice = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // call getStandard() which will return Standard type object
        StandardCoffee standardCoffee = abstractCoffeeFactory.getStandard(choice);
        // Check if required bean and milk units are available , else throw exception
        boolean sufficientStandardBeanUnits = standardCoffee.checkBeanUnits();
        boolean sufficientStandardMilkUnits = standardCoffee.checkMilkUnits();
        // If both are true, coffee is processed and prompted for adding more or main menu
        if (p1.test(sufficientStandardBeanUnits) && p1.test(sufficientStandardMilkUnits)) {
            System.out.println("Coffee processed! Enjoy your drink!!");
            System.out.println("Want to add more cups of coffee?");

            // To add more or return to main menu, Consumer method reference is used from AddMore class for
            //code re-usability
            commonAddMoreBlock.accept(enteredchoice);
        }

    }

    // Method to select from various types of Advanced coffee, Here enteredchoice is 2
    // Description same as getStandard()
    public static void getAdvancedChoice(int enteredchoice) {
        AbstractCoffeeFactory abstractCoffeeFactory = coffeeFactoryParent.selectType(enteredchoice);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the choice for advanced coffee: ");
        System.out.println("Available Advanced coffee are :  ");
        for (Map.Entry<Integer, CoffeeFactoryParent.CoffeeMaps> map1 : CoffeeFactoryParent.CoffeeMaps.coffeeMapUnit.entrySet()) {
            if (map1.getKey() == 4 || map1.getKey() == 5)
                System.out.println(map1.getKey() + "  " + map1.getValue().coffeeType);
        }

        try {
            choice = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


        AdvancedCoffee advancedCoffee = abstractCoffeeFactory.getAdvanced(choice);
        boolean sufficientAdvancedBeanUnits = advancedCoffee.checkBeanUnits();
        boolean sufficientAdvancedMilkUnits = advancedCoffee.checkMilkUnits();
        if (p1.test(sufficientAdvancedBeanUnits) && p1.test(sufficientAdvancedBeanUnits)) {
            System.out.println("Coffee processed! Enjoy your drink!!");

            System.out.println("Want to add more cups of coffee?");


            commonAddMoreBlock.accept(enteredchoice);
        }


    }

    // Method to add Ingredients like Milk/Coffee beans, Here enteredchoice is 3
    // Description same as getStandard()
    public static void getIngredientsChoice(int enteredchoice) {
        AbstractCoffeeFactory abstractCoffeeFactory = coffeeFactoryParent.selectType(enteredchoice);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int ltrsToAdd = 0;
        int unitsToAdd = 0;
        String mainMenu = null;
        String addMoreIngr = null;
        System.out.println("Enter the ingredient you want to add");
        System.out.println(" Available Ingredients are :");
        System.out.println("                            1 Add Milk ");
        System.out.println("                            2 Add Coffee Beans ");
        try {
            choice = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
// Choice 1 is for milk
        if (choice == 1) {
            System.out.println("Enter the litres of Milk you want to add. " +
                    "The highest available capacity is:  " + CoffeeFactoryParent.milkTankCapacity);
            try {
                ltrsToAdd = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Ingredients ingredients = abstractCoffeeFactory.getIngredients(choice);
            System.out.println("Updated milk capacity is : " + ingredients.addMilk(ltrsToAdd));
            commonAddMoreBlock.accept(enteredchoice);


        }

        // Choice 2 is for Coffee beans

        else if (choice == 2) {
            System.out.println("Enter units of coffee beans you want to add. " +
                    "The highest available capacity is:  " + CoffeeFactoryParent.coffeeBeanTankCapacity);
            try {
                unitsToAdd = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Ingredients ingredients = abstractCoffeeFactory.getIngredients(choice);
            System.out.println("Updated coffee bean capacity is : " + ingredients.addCoffee(unitsToAdd));

            commonAddMoreBlock.accept(enteredchoice);


        }


    }


}
