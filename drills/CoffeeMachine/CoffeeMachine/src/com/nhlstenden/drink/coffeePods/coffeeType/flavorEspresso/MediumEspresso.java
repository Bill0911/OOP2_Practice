package com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso;

import com.nhlstenden.drink.coffeePods.coffeeType.Espresso;

public class MediumEspresso extends Espresso
{
    private static final double BASE_BREW_MULTIPLIER = 0.08;

    public MediumEspresso ()
    {
        super(0.1 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 75 || brewingTemperature > 85)
        {
            throw new IllegalArgumentException("This temperature is not going to make it medium");
        }

        this.setCurrentBrewPercentage(getBrewFactor() * brewingTemperature * timeInSeconds);
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "MediumEspresso";
    }
}
