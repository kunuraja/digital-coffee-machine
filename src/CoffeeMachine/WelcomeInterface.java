package CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public interface WelcomeInterface {


// Function to set the welcome page

    static void welcomePage() {

        System.out.println("===================================================================");
        System.out.println("||      Welcome To The Digital World !!! Happy Brewing !!        ||");
        System.out.println("===================================================================");


// Created method reference for calling the standard / advanced / Ingredients methods of CommonChoice class
// The purpose is to re use the code.
        Consumer<Integer> stdCoffee = CommonChoice::getStandardChoice;
        Consumer<Integer> advCoffee = CommonChoice::getAdvancedChoice;
        Consumer<Integer> ingred = CommonChoice::getIngredientsChoice;


        int enteredChoice = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter choice: 1 for Standard coffee.");
        System.out.println("Enter choice: 2 for Advanced coffee.");
        System.out.println("Enter choice: 3 for Adding Ingredients.");
        try {
            enteredChoice = Integer.parseInt(bufferedReader.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (enteredChoice == 1) {
            stdCoffee.accept(enteredChoice);// Call getStandardChoice from CommonChoice class


        } else if (enteredChoice == 2) {

            advCoffee.accept(enteredChoice); // Call getAdvancedChoice from CommonChoice class


        } else if (enteredChoice == 3) {
            ingred.accept(enteredChoice); // Call getIngredientsChoice from CommonChoice class


        }
// If entered any other choice system will prompt for invalid entry and will return to welcome page again
        else {
            while (enteredChoice != 1 && enteredChoice != 2) {

                System.out.println("Invalid Entry. Please try again");

                welcomePage();


            }
        }
    }
}