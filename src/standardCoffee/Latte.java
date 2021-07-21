package standardCoffee;

import CoffeeMachine.CommonBeansMilk;

import java.util.function.Supplier;

public class Latte implements StandardCoffee {


    Supplier<Boolean> chkBeans = CommonBeansMilk::checkBeansForCoffee; // Supplier Method reference for
    // checkBeansForCoffee method in CommonBeansMilk class for code re - usability
    Supplier<Integer> reqBeans = CommonBeansMilk::requiredBeansForCoffee; // Supplier Method reference for
    // requiredBeansForCoffee method in CommonBeansMilk class for code re - usability
    Supplier<Integer> reqMilk = CommonBeansMilk::requiredMilkUnits; // Supplier Method reference for
    // requiredMilkUnits method in CommonBeansMilk class for code re - usability
    Supplier<Boolean> chkMilk = CommonBeansMilk::checkMilkUnits; // Supplier Method reference for
    // checkMilkUnits method in CommonBeansMilk class for code re - usability


    // Identify the required bean units for Latte
    @Override
    public int requiredBeanUnits() {

        return reqBeans.get();

    }

    // Check if sufficient bean units are present to brew coffee
    @Override
    public boolean checkBeanUnits() {

        return chkBeans.get();

    }

    // Identify the required milk units for Latte

    @Override
    public int requiredMilkUnits() {

        return reqMilk.get();
    }

    // Check if sufficient bean units are present to brew latte
    @Override
    public boolean checkMilkUnits() {

        return chkMilk.get();


    }
}
