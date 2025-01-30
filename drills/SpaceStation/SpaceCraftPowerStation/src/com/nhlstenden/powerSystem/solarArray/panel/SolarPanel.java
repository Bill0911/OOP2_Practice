package com.nhlstenden.powerSystem.solarArray.panel;

public abstract class SolarPanel
{
    private double efficiencyPercentage;
    private double totalkWhGenerated;

    public SolarPanel()
    {
        this.efficiencyPercentage = 100.0;
        this.totalkWhGenerated = 0.0;
    }

    public double getEfficiencyPercentage ()
    {
        return efficiencyPercentage;
    }

    public void setEfficiencyPercentage (double efficiencyPercentage)
    {
        if (efficiencyPercentage < 0.0)
        {
            this.efficiencyPercentage = 0.0;
            return;
        }

        this.efficiencyPercentage = efficiencyPercentage;
    }

    public double getTotalkWhGenerated ()
    {
        return totalkWhGenerated;
    }

    public void setTotalkWhGenerated (double totalkWhGenerated)
    {
        this.totalkWhGenerated = totalkWhGenerated;
    }

    public abstract double generatePower(double radiation, int timeInSeconds, int temperature) throws PowerSystemFailureException;
}
