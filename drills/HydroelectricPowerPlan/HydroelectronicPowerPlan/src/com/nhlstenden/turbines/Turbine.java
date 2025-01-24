package com.nhlstenden.turbines;

import com.nhlstenden.controlRoom.Status;
import com.nhlstenden.controlRoom.Statusable;

public abstract class Turbine implements Statusable
{
    private double efficiencyPercentage;
    private double heat;

    public Turbine ()
    {
        this.efficiencyPercentage = 100.0;
        this.heat = 0.0;
    }

    public double getEfficiencyPercentage ()
    {
        return efficiencyPercentage;
    }

    public void setEfficiencyPercentage (double efficiencyPercentage)
    {
        this.efficiencyPercentage = efficiencyPercentage;
    }

    public double getHeat ()
    {
        return heat;
    }

    public void setHeat (double heat)
    {
        this.heat = heat;
    }

    public void calculateHeat(double discharge)
    {
        this.setHeat(discharge * this.efficiencyPercentage * 0.01);
    }

    @Override
    public Status getStatus()
    {
        if (this.efficiencyPercentage < 15.0)
        {
            return Status.NEEDS_ATTENTION;
        }

        return Status.STABLE;
    }

    public abstract DischargeResult discharge(double waterPressure, int timeInSeconds);
}
