package com.nhlstenden.turbines;

public class DischargeResult
{
    private double waterDischarge;
    private double rotationalSpeed;

    public DischargeResult (double waterDischarge, double rotationalSpeed)
    {
        this.waterDischarge = waterDischarge;
        this.rotationalSpeed = rotationalSpeed;
    }

    public double getWaterDischarge ()
    {
        return waterDischarge;
    }

    public void setWaterDischarge (double waterDischarge)
    {
        this.waterDischarge = waterDischarge;
    }

    public double getRotationalSpeed ()
    {
        return rotationalSpeed;
    }

    public void setRotationalSpeed (double rotationalSpeed)
    {
        this.rotationalSpeed = rotationalSpeed;
    }

    @Override
    public String toString ()
    {
        return "DischargeResult\n" + "waterDischarge=" + waterDischarge + ", rotationalSpeed=" + rotationalSpeed;
    }
}
