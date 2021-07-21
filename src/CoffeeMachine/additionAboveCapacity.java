package CoffeeMachine;

// Exception class to throw if ingredients added above maximum capacity
public class additionAboveCapacity extends Exception {
    public additionAboveCapacity(String s) {
        super(s);
    }
}
