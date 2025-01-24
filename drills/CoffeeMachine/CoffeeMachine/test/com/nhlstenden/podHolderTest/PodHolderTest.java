package com.nhlstenden.podHolderTest;
import com.nhlstenden.appliance.podHolder.CoffeeType;
import com.nhlstenden.appliance.podHolder.NoMorePodException;
import com.nhlstenden.appliance.podHolder.PodHolder;
import com.nhlstenden.appliance.podHolder.PodHolderEmptyException;
import com.nhlstenden.drink.coffeePods.CoffeePod;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.MediumCappuccino;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.StrongCappuccino;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PodHolderTest
{
    @Test void getNextPod_ShouldReturnThePod() throws NoMorePodException, PodHolderEmptyException
    {
        CoffeePod strongCappuccino = new StrongCappuccino();
        CoffeePod mediumCappuccino = new MediumCappuccino();

        PodHolder holder = new PodHolder();
        holder.addCoffeePod(strongCappuccino);
        holder.addCoffeePod(mediumCappuccino);

        assertEquals(strongCappuccino, holder.getNextStrongCappuccino());
    }

    @Test void getNextPod_ShouldYellRunOutOfPod() throws NoMorePodException, PodHolderEmptyException
    {
        CoffeePod strongCappuccino = new StrongCappuccino();
        CoffeePod mediumCappuccino = new MediumCappuccino();

        PodHolder holder = new PodHolder();
        holder.addCoffeePod(strongCappuccino);
        holder.addCoffeePod(mediumCappuccino);

        assertEquals(strongCappuccino, holder.getNextStrongCappuccino()); // get one pod
        assertThrows(NoMorePodException.class, () -> holder.getNextItem(CoffeeType.STRONG_CAPPUCCINO));
    }


}
