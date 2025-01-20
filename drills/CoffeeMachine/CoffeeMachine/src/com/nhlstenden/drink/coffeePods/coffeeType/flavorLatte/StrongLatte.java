package com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte;

import com.nhlstenden.drink.coffeePods.coffeeType.Latte;

public class StrongLatte extends Latte
{

    public static final double BASE_BREW_MULTIPLIER = 0.12;

    public StrongLatte ()
    {
        super(0.06 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 85 || brewingTemperature > 95)
        {
            throw new IllegalArgumentException("This temperature is not going to make it strong");
        }

        this.setCurrentBrewPercentage(this.getCurrentBrewPercentage() + (1.5 * (this.getBrewFactor() * brewingTemperature) * timeInSeconds));
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "StrongLatte";
    }
}
