package com.nhlstenden.food.meat;

import com.nhlstenden.food.Food;

public abstract class Meat extends Food
{
    private MeatType meatType;
    private double cookingFactor;
    private double currentCookedPercentage;

    public Meat(MeatType meatType, double cookingFactor, double tanningFactor)
    {
        super(tanningFactor);
        this.meatType = meatType;
        this.cookingFactor = cookingFactor;
        this.currentCookedPercentage = 0.0;
    }

    public MeatType getMeatType ()
    {
        return meatType;
    }

    public void setMeatType (MeatType meatType)
    {
        this.meatType = meatType;
    }

    public double getCookingFactor ()
    {
        return cookingFactor;
    }

    public void setCookingFactor (double cookingFactor)
    {
        this.cookingFactor = cookingFactor;
    }

    public double getCurrentCookedPercentage ()
    {
        return currentCookedPercentage;
    }

    public void setCurrentCookedPercentage (double currentCookedPercentage)
    {
        this.currentCookedPercentage = currentCookedPercentage;
    }

    @Override
    public void grill(int temperature, int timeInSeconds) {
        if (this.cookingFactor != 0) {
            double newCookedPercentage = this.getCurrentCookedPercentage() + ((1 / (this.cookingFactor * Math.PI)) * temperature);
            this.setCurrentCookedPercentage(Math.min(newCookedPercentage, 100));
        }

        double newTanningPercentage = this.getCurrentTanningPercentage() + (this.getTanningFactor() * (temperature / 100.0));
        this.setCurrentTanningPercentage(Math.min(newTanningPercentage, 100));
    }
}
