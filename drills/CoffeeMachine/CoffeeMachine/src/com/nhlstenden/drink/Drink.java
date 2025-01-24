package com.nhlstenden.drink;

import com.nhlstenden.appliance.thermometer.Measurable;

public abstract class Drink implements Measurable
{
    private double currentTemperature;
    private double currentFrothPercentage;

    public Drink()
    {
        this.currentTemperature = 0.0;
        this.currentFrothPercentage = 0.0;
    }

    public double getCurrentTemperature ()
    {
        return currentTemperature;
    }

    @Override
    public int getTemperature ()
    {
        return (int) this.currentTemperature;
    }

    public void setCurrentTemperature (double currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }

    public double getCurrentFrothPercentage ()
    {
        return currentFrothPercentage;
    }

    public void setCurrentFrothPercentage (double currentFrothPercentage)
    {
        this.currentFrothPercentage = currentFrothPercentage;
    }
}
