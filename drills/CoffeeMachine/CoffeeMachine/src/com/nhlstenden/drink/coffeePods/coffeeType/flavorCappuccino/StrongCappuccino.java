package com.nhlstenden.drink.coffeePods.coffeeType.flavorCappuccino;

import com.nhlstenden.drink.coffeePods.coffeeType.Cappuccino;

public class StrongCappuccino extends Cappuccino
{
    private static final double BASE_BREW_MULTIPLIER = 0.12;

    public StrongCappuccino ()
    {
        super(0.08 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 85 || brewingTemperature > 95)
        {
            throw new IllegalArgumentException("This temperature is going not make it strong");
        }

        this.setCurrentBrewPercentage(1.5 * this.getBrewFactor() * brewingTemperature * timeInSeconds);
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "StrongCappuccino";
    }
}
