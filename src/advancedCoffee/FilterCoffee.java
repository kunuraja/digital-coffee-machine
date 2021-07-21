package advancedCoffee;

import CoffeeMachine.CommonBeansMilk;

import java.util.function.Supplier;

public class FilterCoffee implements AdvancedCoffee {

    // Description same as Standard Coffee
    Supplier<Boolean> chkBeans = CommonBeansMilk::checkBeansForCoffee;
    Supplier<Integer> reqBeans = CommonBeansMilk::requiredBeansForCoffee;
    Supplier<Integer> reqMilk = CommonBeansMilk::requiredMilkUnits;
    Supplier<Boolean> chkMilk = CommonBeansMilk::checkMilkUnits;


    @Override
    public int requiredBeanUnits() {
        {

            return reqBeans.get();


        }
    }

    @Override
    public boolean checkBeanUnits() {

        return chkBeans.get();
    }

    @Override
    public int requiredMilkUnits() {

        return reqMilk.get();
    }

    @Override
    public boolean checkMilkUnits() {

        return chkMilk.get();
    }
}
