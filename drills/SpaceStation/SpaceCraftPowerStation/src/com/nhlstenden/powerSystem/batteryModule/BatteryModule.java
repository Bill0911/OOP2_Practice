package com.nhlstenden.powerSystem.batteryModule;

public class BatteryModule
{
    public static final int MAX_POWER_CAPACITY = 1000;
    private double amountOfPowerInKWh;

    public BatteryModule()
    {
        this.amountOfPowerInKWh = 0.0;
    }

    public double getAmountOfPowerInKWh ()
    {
        return amountOfPowerInKWh;
    }

    public void setAmountOfPowerInKWh (double amountOfPowerInKWh)
    {
        this.amountOfPowerInKWh = amountOfPowerInKWh;
    }

    public void storeEnergy(double kWh)
    {
        if (kWh < 0.0)
        {
            this.setAmountOfPowerInKWh(amountOfPowerInKWh);
            return;
        }

        if (amountOfPowerInKWh + kWh > MAX_POWER_CAPACITY)
        {
            this.setAmountOfPowerInKWh(MAX_POWER_CAPACITY);
            return;
        }

        this.amountOfPowerInKWh += kWh;
    }
}
