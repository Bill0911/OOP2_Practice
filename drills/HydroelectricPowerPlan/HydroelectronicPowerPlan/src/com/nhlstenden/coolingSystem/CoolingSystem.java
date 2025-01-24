package com.nhlstenden.coolingSystem;

import com.nhlstenden.controlRoom.Status;
import com.nhlstenden.controlRoom.Statusable;

public class CoolingSystem implements Statusable
{
    private double waterTemperature;

    public CoolingSystem ()
    {
        this.waterTemperature = 0.0;
    }

    public double getWaterTemperature ()
    {
        return waterTemperature;
    }

    public void setWaterTemperature (double waterTemperature)
    {
        this.waterTemperature = waterTemperature;
    }

    public void coolTurbine(double heat)
    {
        this.setWaterTemperature(this.getWaterTemperature() + (heat * 0.45));
    }

    @Override
    public Status getStatus()
    {
        if (this.waterTemperature >= 50 && this.waterTemperature <= 60)
        {
            return Status.NEEDS_ATTENTION;
        }

        if (this.waterTemperature > 60)
        {
            return Status.UNSTABLE;
        }

        return Status.STABLE;
    }

    @Override
    public String toString ()
    {
        return "CoolingSystem\n" + "waterTemperature=" + waterTemperature;
    }
}
