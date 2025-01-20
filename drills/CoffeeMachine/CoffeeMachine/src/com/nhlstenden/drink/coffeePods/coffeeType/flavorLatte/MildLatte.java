package com.nhlstenden.drink.coffeePods.coffeeType.flavorLatte;

import com.nhlstenden.drink.coffeePods.coffeeType.Latte;

public class MildLatte extends Latte
{

    public static final double BASE_BREW_MULTIPLIER = 0.08;

    public MildLatte()
    {
        super(0.06 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewTemperature)
    {
        if (brewTemperature < 60 || brewTemperature > 75)
        {
            throw new IllegalArgumentException("This temperature is not going to make it mild");
        }

        this.setCurrentBrewPercentage(this.getCurrentBrewPercentage() + (this.getBrewFactor() * brewTemperature * timeInSeconds));
        this.heatUp(timeInSeconds, brewTemperature);
    }

    @Override
    public String toString ()
    {
        return "MildLatte";
    }
}
