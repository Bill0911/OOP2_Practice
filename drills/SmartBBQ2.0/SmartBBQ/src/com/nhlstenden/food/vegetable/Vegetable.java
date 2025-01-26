package com.nhlstenden.food.vegetable;

import com.nhlstenden.food.Food;

public class Vegetable extends Food
{
    private double moistFactor;
    private double moistPercentage;

    public Vegetable (double tanningFactor, double moistFactor)
    {
        super(tanningFactor);
        this.moistFactor = moistFactor;
        this.moistPercentage = 100;
    }

    public double getMoistFactor ()
    {
        return moistFactor;
    }

    public void setMoistFactor (double moistFactor)
    {
        this.moistFactor = moistFactor;
    }

    public double getMoistPercentage ()
    {
        return moistPercentage;
    }

    public void setMoistPercentage (double moistPercentage)
    {
        this.moistPercentage = moistPercentage;
    }

    public void moistDecrease(double difference)
    {
        if ((getPercentage() - difference) < 0)
        {
            this.setMoistPercentage(0);
            return;
        }
        
        this.moistPercentage -= difference;
    }

    private double getPercentage ()
    {
        return this.moistPercentage;
    }

    @Override
    public void grill (int temperature, int timeInSeconds)
    {
        this.setCurrentTanningPercentage(this.getCurrentTanningPercentage() + (this.getTanningFactor() * temperature));
        this.moistDecrease(this.moistFactor * temperature);
    }
}





























