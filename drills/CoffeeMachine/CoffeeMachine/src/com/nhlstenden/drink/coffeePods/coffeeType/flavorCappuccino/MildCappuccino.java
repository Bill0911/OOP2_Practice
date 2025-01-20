package com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino;

import com.nhlstenden.drink.coffeePods.coffeeType.Cappuccino;

public class MildCappuccino extends Cappuccino
{
    private static final double BASE_BREW_MULTIPLIER = 0.08;

    public MildCappuccino ()
    {
        super(0.08 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 60 || brewingTemperature > 75)
        {
            throw new IllegalArgumentException("This temperature is not going to make it mild");
        }
        this.setCurrentBrewPercentage(this.getCurrentBrewPercentage() + (0.5 * (this.getBrewFactor() * brewingTemperature * timeInSeconds)));
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "MildCappuccino";
    }
}
