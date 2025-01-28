import com.nhlstenden.appliance.smartbbq.SmartBBQ;
import com.nhlstenden.food.Food;
import com.nhlstenden.food.meat.Hamburger;
import com.nhlstenden.food.vegetable.BellPepper;
import com.nhlstenden.food.vegetable.Corn;

public class Main
{
    public static void main (String[] args)
    {
        SmartBBQ grill = new SmartBBQ();

        Food pepper = new BellPepper();
        Food hamburger = new Hamburger();
        Food corn = new Corn();

        grill.addFood(pepper);
        grill.addFood(corn);

        //grill.turnOn(80);
        grill.startGrillSession(130, 1300);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(pepper.getTemperature());
    }
}