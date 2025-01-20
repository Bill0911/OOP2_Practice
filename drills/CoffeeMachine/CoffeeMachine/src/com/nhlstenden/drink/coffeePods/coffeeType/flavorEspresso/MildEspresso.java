package com.nhlstenden.drink.coffeePods.coffeeType.flavorEspresso;

import com.nhlstenden.drink.coffeePods.coffeeType.Espresso;

public class MildEspresso extends Espresso
{
    private static final double BASE_BREW_MULTIPLIER = 0.08;

    public MildEspresso ()
    {
        super(0.1 + BASE_BREW_MULTIPLIER);
    }

    @Override
    public void startMakingCoffee(int timeInSeconds, int brewingTemperature)
    {
        if (brewingTemperature < 60 || brewingTemperature > 75)
        {
            throw new IllegalArgumentException("This temperature is not going to make it mild");
        }

        this.setCurrentBrewPercentage(0.5 * (this.getBrewFactor() * brewingTemperature) * timeInSeconds);
        this.heatUp(timeInSeconds, brewingTemperature);
    }

    @Override
    public String toString ()
    {
        return "MildEspresso";
    }
}
