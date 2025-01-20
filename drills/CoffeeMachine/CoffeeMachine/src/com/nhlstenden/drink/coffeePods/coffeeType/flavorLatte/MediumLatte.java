package com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte;

import com.nhlstenden.drink.coffeePods.coffeeType.Latte;

public class MediumLatte extends Latte
{

    public static final double BASE_BREW_MULTIPLIER = 0.12;

    public MediumLatte ()
    {
        super(0.06 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 75 || brewingTemperature > 85)
        {
            throw new IllegalArgumentException("This temperature is not going to make it medium");
        }

        this.setCurrentBrewPercentage(this.getCurrentBrewPercentage() + (1.5 * (this.getBrewFactor() * brewingTemperature) * timeInSeconds));
        this.heatUp(timeInSeconds, timeInSeconds);
    }

    @Override
    public String toString ()
    {
        return "MediumLatte";
    }
}
