package com.nhlstenden.drink.coffeePods.coffeeType;

import com.nhlstenden.drink.coffeePods.CoffeePod;

public abstract class Espresso extends CoffeePod
{
    public Espresso (double brewFactor)
    {
        super(brewFactor, 0);
    }

    @Override
    public void heatUp(int timeInSeconds, int temperature)
    {
        this.setCurrentTemperature(this.getDrinkTemperatureIncreaseInSeconds(25, timeInSeconds));
    }
}
