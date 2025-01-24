package com.nhlstenden.appliance.podHolder;

import com.nhlstenden.appliance.thermometer.Measurable;
import com.nhlstenden.drink.coffeePods.CoffeePod;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.MediumCappuccino;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.MildCappuccino;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino.StrongCappuccino;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso.MediumEspresso;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso.MildEspresso;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso.StrongEspresso;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte.MediumLatte;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte.MildLatte;
import com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte.StrongLatte;

import java.util.ArrayList;
import java.util.List;

public class PodHolder implements Measurable
{
    private List<CoffeePod> coffeePods;
    private int temperature;
    private static PodHolder instance;

    public PodHolder()
    {
        this.temperature = 20;
        this.coffeePods = new ArrayList<>();
    }

    public List<CoffeePod> getCoffeePods ()
    {
        return coffeePods;
    }

    public void setCoffeePods (List<CoffeePod> coffeePods)
    {
        this.coffeePods = coffeePods;
    }

    @Override
    public int getTemperature ()
    {
        return this.temperature;
    }

    public void setTemperature (int temperature)
    {
        this.temperature = temperature;
    }

    public static PodHolder getInstance()
    {
        if (null == instance)
        {
            instance = new PodHolder();
        }

        return instance;
    }

    public void addCoffeePod(CoffeePod pod)
    {
        this.coffeePods.add(pod);
    }

    private CoffeePod getNextItem(CoffeeType type) throws NoMorePodException, PodHolderEmptyException
    {
        if (this.coffeePods.isEmpty())
        {
            throw new PodHolderEmptyException();
        }

        for (int i = 0; i < this.coffeePods.size(); i++)
        {
            CoffeePod pod = this.coffeePods.get(i);
            if (pod.getCoffeeType().equals(type))
            {
                return this.coffeePods.remove(i);
            }
        }

        throw new NoMorePodException("Hell no, no more" + type.name());
    }

    public MildCappuccino getNextMildCappuccino()
    {
        return (MildCappuccino) getNextItem(CoffeeType.MILD_CAPPUCCINO);
    }

    public MildEspresso getNextMildEspresso()
    {
        return (MildEspresso)  getNextItem(CoffeeType.MILD_ESPRESSO);
    }

    public MildLatte getNextMildLatte()
    {
        return (MildLatte) getNextItem(CoffeeType.MILD_LATTE);
    }

    public MediumCappuccino getNextMediumCappuccino()
    {
        return (MediumCappuccino) getNextItem(CoffeeType.MEDIUM_CAPPUCCINO);
    }

    public MediumEspresso getNextMediumEspresso()
    {
        return (MediumEspresso) getNextItem(CoffeeType.MEDIUM_ESPRESSO);
    }

    public MediumLatte getNextMediumLatte()
    {
        return (MediumLatte) getNextItem(CoffeeType.MEDIUM_LATTE);
    }

    public StrongCappuccino getNextStrongCappuccino()
    {
        return (StrongCappuccino) getNextItem(CoffeeType.STRONG_CAPPUCCINO);
    }

    public StrongEspresso getNextStrongEspresso()
    {
        return (StrongEspresso) getNextItem(CoffeeType.STRONG_ESPRESSO);
    }

    public StrongLatte getNextStrongLatte()
    {
        return (StrongLatte) getNextItem(CoffeeType.STRONG_LATTE);
    }
}
