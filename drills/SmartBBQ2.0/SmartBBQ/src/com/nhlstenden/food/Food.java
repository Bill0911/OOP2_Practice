package com.nhlstenden.food;

import com.nhlstenden.appliance.thermometer.Measurable;

public abstract class Food implements Measurable
{
    private double tanningFactor;
    private int currentTemperature;
    private double currentTanningPercentage;

    public Food (double tanningFactor)
    {
        this.tanningFactor = tanningFactor;
        this.currentTemperature = 0;
    }

    public double getTanningFactor ()
    {
        return tanningFactor;
    }

    public void setTanningFactor (double tanningFactor)
    {
        this.tanningFactor = tanningFactor;
    }

    @Override
    public int getTemperature ()
    {
        return currentTemperature;
    }

    public void setCurrentTemperature (int currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }

    public double getCurrentTanningPercentage ()
    {
        return currentTanningPercentage;
    }

    public void setCurrentTanningPercentage (double currentTanningPercentage)
    {
        this.currentTanningPercentage = currentTanningPercentage;
    }

    public abstract void grill (int temperature, int timeInSeconds);
}
