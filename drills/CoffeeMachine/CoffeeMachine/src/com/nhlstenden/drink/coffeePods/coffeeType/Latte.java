package com.nhlstenden.drink.coffeePods.coffeeType;

import com.nhlstenden.drink.coffeePods.CoffeePod;

public abstract class Latte extends CoffeePod
{
    public Latte (double brewFactor)
    {
        super(brewFactor, 0.4);
    }

    @Override
    public void heatUp(int timeInSeconds, int temperature)
    {
        this.setCurrentTemperature(this.getCurrentTemperature() + this.getDrinkTemperatureIncreaseInSeconds(35, timeInSeconds));
        this.setCurrentFrothPercentage(this.getCurrentFrothPercentage() + (temperature * this.getFrothFactor()));
    }
}
