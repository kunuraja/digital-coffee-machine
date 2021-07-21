package CoffeeMachine;

import advancedCoffee.AdvancedFactory;
import ingredients.CoffeeBeans;
import ingredients.Milk;
import standardCoffee.StandardFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class CommonBeansMilk {

    static Predicate<Integer> p1 = (c1) -> !c1.equals(0);// Predicate to test if coffee index not equals 0
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int unitsToAdd = 0;
    static int ltrsToAdd = 0;
    public static int requiredBeanUnits;

// Method to identify the required coffee beans for the coffee

    public static int requiredBeansForCoffee() {

        int coffeeIndex = AdvancedFactory.coffeeChoice;// Advanced coffee choice (4/5)
        int coffeeIndex1 = StandardFactory.coffeechoice;// Standard coffee choice (1/2/3)
        int coffeeidx;

// If standard coffeeIndex is 0 then advanced coffeeIndex else standard coffeeIndex
        if (p1.test(coffeeIndex))
            coffeeidx = coffeeIndex;
        else coffeeidx = coffeeIndex1;
// Retrieve the value (object) for the particular key
        CoffeeFactoryParent.CoffeeMaps coffeeBeans = CoffeeFactoryParent.CoffeeMaps.coffeeMapUnit.get(coffeeidx);
        // Retrieve the bean units
        int requiredBeanUnits = coffeeBeans.beanUnits;

        System.out.println("Required Bean Units: " + requiredBeanUnits);

        return requiredBeanUnits;


    }

    public static boolean checkBeansForCoffee() {
        // Return the required bean units for a particular coffee
        requiredBeanUnits = requiredBeansForCoffee();
        // Predicate to check if available bean units are greater than or equal to required bean units for coffee
        Predicate<Integer> p1 = (b1) -> b1 >= requiredBeanUnits;
// If the available beans are equal/ greater than required bean units, then updated available bean units are returned
        if (p1.test(CoffeeFactoryParent.availableBeanUnits)) {
            CoffeeFactoryParent.availableBeanUnits = CoffeeFactoryParent.availableBeanUnits - requiredBeanUnits;
            System.out.println("Available bean units : " + CoffeeFactoryParent.availableBeanUnits);
            return true;
        } else {


// Else insufficientBeans exception is thrown
            try {
                throw new InsufficientBeans("Required " + requiredBeanUnits + " bean units are not present, please add more if wish to brew coffee");
            } catch (InsufficientBeans insufficientBeans) {
                insufficientBeans.printStackTrace();
                // ===============Allow to add Coffee beans iff enough beans not available=================================
                System.out.println("Enter units of coffee beans you want to add. " +
                        "The highest available capacity is:  " + CoffeeFactoryParent.coffeeBeanTankCapacity);
                try {
                    unitsToAdd = Integer.parseInt(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                CoffeeBeans coffeeBeans = new CoffeeBeans();
                System.out.println("Updated coffee bean capacity is : " + coffeeBeans.addCoffee(unitsToAdd));
                WelcomeInterface.welcomePage();

            }
            return false;
        }
    }

    // Description same as requiredBeanUnits
    public static int requiredMilkUnits() {

        int milkIndex = AdvancedFactory.coffeeChoice;
        int milkIndex1 = StandardFactory.coffeechoice;
        int milkidx;


        if (p1.test(milkIndex))
            milkidx = milkIndex;
        else milkidx = milkIndex1;


        CoffeeFactoryParent.CoffeeMaps latteCoffee = CoffeeFactoryParent.CoffeeMaps.coffeeMapUnit.get(milkidx);
        int requiredMilkUnits = latteCoffee.milkUnits;

        System.out.println("Required Milk Units: " + requiredMilkUnits);

        return requiredMilkUnits;

    }

    // Description same as checkBeansForCoffee()
    public static boolean checkMilkUnits() {
        int requiredMilkUnits = requiredMilkUnits();
        Predicate<Integer> p1 = (b1) -> b1 >= requiredMilkUnits;

        if (p1.test(CoffeeFactoryParent.availableMilkUnits)) {
            CoffeeFactoryParent.availableMilkUnits = CoffeeFactoryParent.availableMilkUnits - requiredMilkUnits;
            System.out.println("Available Milk units : " + CoffeeFactoryParent.availableMilkUnits);
            return true;
        } else {


            try {
                throw new InsufficientMilk("Required " + requiredMilkUnits + " milk units are not present," +
                        " please add more if wish to brew coffee");
            } catch (InsufficientMilk insufficientMilk) {
                insufficientMilk.printStackTrace();
                // ===============Allow to add Milk iff enough milk not available=================================
                System.out.println("Enter the litres of Milk you want to add. " +
                        "The highest available capacity is:  " + CoffeeFactoryParent.milkTankCapacity);
                try {
                    ltrsToAdd = Integer.parseInt(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Milk milk = new Milk();
                System.out.println("Updated milk capacity is : " + milk.addMilk(ltrsToAdd));
                WelcomeInterface.welcomePage();


            }


            return false;
        }


    }


}
