package com.nhlstenden.drink.coffeePods.coffeeType;

import com.nhlstenden.drink.coffeePods.CoffeePod;

public abstract class Cappuccino extends CoffeePod
{
    public Cappuccino (double brewFactor)
    {
        super(brewFactor, 0.05);
    }

    @Override
    public void heatUp(int timeInSeconds, int temperature)
    {
        this.setCurrentTemperature(this.getDrinkTemperatureIncreaseInSeconds(30, timeInSeconds));
        this.setCurrentFrothPercentage(this.getCurrentFrothPercentage() + (this.getBrewFactor() * temperature));
    }
}
