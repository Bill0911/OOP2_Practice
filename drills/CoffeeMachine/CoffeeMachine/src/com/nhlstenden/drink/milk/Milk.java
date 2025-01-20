package com.nhlstenden.drink.milk;

import com.nhlstenden.drink.Drink;

public class Milk extends Drink
{
    private double currentFrothPercentage;
    private double currentTemperature;
    public Milk ()
    {
        this.currentFrothPercentage = this.getCurrentFrothPercentage();
        this.currentTemperature = this.getCurrentTemperature();
    }

    @Override
    public double getCurrentFrothPercentage ()
    {
        return currentFrothPercentage;
    }

    @Override
    public void setCurrentFrothPercentage (double currentFrothPercentage)
    {
        this.currentFrothPercentage = currentFrothPercentage;
    }

    @Override
    public double getCurrentTemperature ()
    {
        return currentTemperature;
    }

    @Override
    public void setCurrentTemperature (double currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }
}
