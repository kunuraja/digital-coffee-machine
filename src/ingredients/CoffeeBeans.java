package ingredients;

import CoffeeMachine.CoffeeFactoryParent;
import CoffeeMachine.WelcomeInterface;
import CoffeeMachine.additionAboveCapacity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeBeans implements Ingredients {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    // Overridden method to add coffee beans to the coffee machine tank

    @Override
    public int addCoffee(int unitsToAdd) {
        int checkBeanTankCapacity = Ingredients.checkCoffeeBeanCapacity();

        if (checkBeanTankCapacity == CoffeeFactoryParent.availableBeanUnits) {
            try {
                throw new additionAboveCapacity("Coffee machine tank is full. You cant add more Coffee");
            } catch (CoffeeMachine.additionAboveCapacity additionAboveCapacity) {
                additionAboveCapacity.printStackTrace();
                WelcomeInterface.welcomePage();
            }
        }

        // DescriptionSame as Milk class
        if ((unitsToAdd + CoffeeFactoryParent.availableBeanUnits) <= checkBeanTankCapacity) {
            CoffeeFactoryParent.availableBeanUnits = CoffeeFactoryParent.availableBeanUnits + unitsToAdd;
            CoffeeFactoryParent.setAvailableBeanUnits(CoffeeFactoryParent.availableBeanUnits);

        }
        // DescriptionSame as Milk class
        else {
            try {
                throw new additionAboveCapacity("Units added are above the allowed maximum capacity");
            } catch (CoffeeMachine.additionAboveCapacity additionAboveCapacity) {
                additionAboveCapacity.printStackTrace();
                System.out.println("Please add beans less than or equal to  " +
                        (checkBeanTankCapacity - CoffeeFactoryParent.availableBeanUnits));
                System.out.println("Enter units of coffee beans you want to add. ");
                // DescriptionSame as Milk class
                try {
                    unitsToAdd = Integer.parseInt(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                addCoffee(unitsToAdd);

            }
        }

        return CoffeeFactoryParent.availableBeanUnits;


    }
}
