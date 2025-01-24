import com.nhlstenden.appliance.coffeeMachine.CoffeeMachine;
import com.nhlstenden.appliance.podHolder.NoMorePodException;
import com.nhlstenden.appliance.podHolder.PodHolder;
import com.nhlstenden.appliance.podHolder.PodHolderEmptyException;
import com.nhlstenden.appliance.thermometer.ThermoResult;
import com.nhlstenden.appliance.thermometer.Thermometer;
import com.nhlstenden.drink.coffeePods.CoffeePod;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.MediumCappuccino;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.MildCappuccino;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso.MediumEspresso;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso.MildEspresso;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso.StrongEspresso;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte.MildLatte;

public class Main
{
    public static void main (String[] args)
    {
        CoffeeMachine machine = new CoffeeMachine();

        MediumEspresso espresso1 = new MediumEspresso();
        CoffeePod espresso2 = new MildEspresso();
        CoffeePod espresso3 = new StrongEspresso();

        CoffeePod cappuccino1 = new MildCappuccino();
        CoffeePod cappuccino2 = new MediumCappuccino();

        CoffeePod latte1 = new MildLatte();

        PodHolder holder = new PodHolder();

        //machine.addDrink(cappuccino1);
        //machine.addDrink(espresso2);
        MediumEspresso mediumEspresso;


        Thermometer thermometer = new Thermometer();
        try
        {
            holder.addCoffeePod(latte1);
            holder.addCoffeePod(espresso1);
            machine.addDrink(espresso1);
            mediumEspresso = holder.getInstance().getNextMediumEspresso();

            machine.addDrink(mediumEspresso);
            machine.addDrink(PodHolder.getInstance().getNextMediumCappuccino());
            machine.turnOn(75);

            thermometer.getResult(mediumEspresso);
            machine.setTemperature(80);
            System.out.print(thermometer.getResult(mediumEspresso));


        }
        catch (PodHolderEmptyException e)
        {
            System.out.println("There is no more pod in the holder1!");
        }
        catch (NoMorePodException e)
        {
            System.out.println("There is no more pod in the holder!");
        }
    }
}