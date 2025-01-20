package com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso;

import com.nhlstenden.drink.coffeePods.coffeeType.Espresso;

public class StrongEspresso extends Espresso
{
    private static final double BASE_BREW_MULTIPLIER = 0.12;

    public StrongEspresso ()
    {
        super(0.1 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 85 || brewingTemperature > 95)
        {
            throw new IllegalArgumentException("This temperature is not going to make it strong");
        }

        this.setCurrentBrewPercentage(1.5 * (this.getBrewFactor() * brewingTemperature) * timeInSeconds);
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "StrongEspresso";
    }
}
