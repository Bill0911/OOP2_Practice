package com.nhlstenden.generator;

import com.nhlstenden.controlRoom.Status;
import com.nhlstenden.controlRoom.Statusable;

public class Generator implements Statusable
{
    private double totalAmountOfKwh;

    public Generator()
    {
        this.totalAmountOfKwh = 0.0;
    }

    public double getTotalAmountOfKwh ()
    {
        return totalAmountOfKwh;
    }

    public void setTotalAmountOfKwh (double totalAmountOfKwh)
    {
        this.totalAmountOfKwh = totalAmountOfKwh;
    }

    public double generateEnergy(double waterDischarge)
    {
        double producedKwh = waterDischarge * 9.81;
        this.setTotalAmountOfKwh(this.getTotalAmountOfKwh() + producedKwh);

        return producedKwh;
    }

    @Override
    public Status getStatus()
    {
        if (this.totalAmountOfKwh > 1000)
        {
            return Status.UNSTABLE;
        }

        return Status.STABLE;
    }

    @Override
    public String toString ()
    {
        return "Generator\n" + "totalAmountOfKwh=" + totalAmountOfKwh;
    }
}
