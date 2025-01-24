package com.nhlstenden.drink.coffeePods;

import com.nhlstenden.appliance.podHolder.CoffeeType;
import com.nhlstenden.drink.Drink;

public abstract class CoffeePod extends Drink
{
    private double brewFactor;
    private double frothFactor;
    private double currentBrewPercentage;
    private CoffeeType coffeeType;

    public CoffeePod(double brewFactor, double frothFactor)
    {
        this.brewFactor = brewFactor;
        this.frothFactor = frothFactor;
        this.currentBrewPercentage = 0.0;
    }

    public double getBrewFactor ()
    {
        return brewFactor;
    }

    public void setBrewFactor (double brewFactor)
    {
        this.brewFactor = brewFactor;
    }

    public double getFrothFactor ()
    {
        return frothFactor;
    }

    public CoffeeType getCoffeeType ()
    {
        return coffeeType;
    }

    public void setCoffeeType (CoffeeType coffeeType)
    {
        this.coffeeType = coffeeType;
    }

    public void setFrothFactor (double frothFactor)
    {
        this.frothFactor = frothFactor;
    }

    public double getCurrentBrewPercentage ()
    {
        return currentBrewPercentage;
    }

    public void setCurrentBrewPercentage (double currentBrewPercentage)
    {
        this.currentBrewPercentage = currentBrewPercentage;
    }

    public double getDrinkTemperatureIncreaseInSeconds(int temperature ,int timeInSeconds)
    {
        return temperature + (0.5 * timeInSeconds);
    }

    public abstract void heatUp(int timeInSeconds, int temperature);

    public abstract void startMakingCoffee (int timeInSeconds, int brewingTemperature);
}
