package CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Common class to call add more each time for code re-usability
public class AddMore {
    public static String addMore;

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // Common method to call for add more or return to main menu

    public static void addMoreOrMainMenu(int enteredchoice) {

        System.out.println("To add more  press + , To go main menu press m");
        System.out.println("Press any key to exit");
        try {
            addMore = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // On passing "+" string, if initially enteredchoice is 1-> getStandardChoice,
        // 2->getAdvancedChoice, 3-> getIngredientsChoice would be called respectively

        if (addMore.equals("+")) {
            if (enteredchoice == 1) CommonChoice.getStandardChoice(enteredchoice);
            else if (enteredchoice == 2) CommonChoice.getAdvancedChoice(enteredchoice);
            else if (enteredchoice == 3) CommonChoice.getIngredientsChoice(enteredchoice);
        }
        // If entered option is "m" it return to welcome page. It will exit system if any other key is pressed
        else if (addMore.equals("m"))
            WelcomeInterface.welcomePage();
        else
            System.exit(0);

    }

}
