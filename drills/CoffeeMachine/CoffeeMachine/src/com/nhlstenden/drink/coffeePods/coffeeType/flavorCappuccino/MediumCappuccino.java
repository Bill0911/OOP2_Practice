package com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino;

import com.nhlstenden.drink.coffeePods.coffeeType.Cappuccino;

public class MediumCappuccino extends Cappuccino
{
    private static final double BASE_BREW_MULTIPLIER = 0.1;

    public MediumCappuccino ()
    {
        super(0.08 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 75 || brewingTemperature > 85)
        {
            throw new IllegalArgumentException("This temperature is not going to make it medium");
        }

        this.setCurrentBrewPercentage(this.getBrewFactor() * brewingTemperature * timeInSeconds);
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "MediumCappuccino";
    }
}
