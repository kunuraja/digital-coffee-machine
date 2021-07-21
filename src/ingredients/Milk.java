package ingredients;

import CoffeeMachine.CoffeeFactoryParent;
import CoffeeMachine.WelcomeInterface;
import CoffeeMachine.additionAboveCapacity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Milk implements Ingredients {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // Overridden method to add Milk
    @Override
    public int addMilk(int ltrsToAdd) {
        // Check the total milk tank capacity of coffee machine
        int checkMilkTankCapacity = Ingredients.checkMilkTankCapacity();
        // If milk tank capacity is already full, it will throw exception
        if (checkMilkTankCapacity == CoffeeFactoryParent.availableMilkUnits) {
            try {
                throw new additionAboveCapacity("Coffee machine tank is full. You cant add more milk");
            } catch (CoffeeMachine.additionAboveCapacity additionAboveCapacity) {
                additionAboveCapacity.printStackTrace();
                WelcomeInterface.welcomePage();
            }
        }


        // If the ltrs of milk to add + initial available litres of milk is less than milk tank capacity
        // then only milk can be added to machine
        if ((ltrsToAdd + CoffeeFactoryParent.availableMilkUnits) <= checkMilkTankCapacity) {

            CoffeeFactoryParent.availableMilkUnits = CoffeeFactoryParent.availableMilkUnits + ltrsToAdd;
            CoffeeFactoryParent.setAvailableMilkUnits(CoffeeFactoryParent.availableMilkUnits);
        }
        // Else additionAboveCapacity exception is thrown and again system will prompt to add less litres of milk
        else {
            try {
                throw new additionAboveCapacity("Units added are above the allowed maximum capacity");
            } catch (CoffeeMachine.additionAboveCapacity additionAboveCapacity) {
                additionAboveCapacity.printStackTrace();
                System.out.println("Please add milk less than or equal to  " +
                        (checkMilkTankCapacity - CoffeeFactoryParent.availableMilkUnits));
                System.out.println("Enter the litres of Milk you want to add. ");
                try {
                    ltrsToAdd = Integer.parseInt(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                addMilk(ltrsToAdd);

            }

        }
        return CoffeeFactoryParent.availableMilkUnits;

    }
}