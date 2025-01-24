package com.nhlstenden.turbines.type;

import com.nhlstenden.turbines.DischargeResult;
import com.nhlstenden.turbines.Turbine;
import com.nhlstenden.turbines.TurbineFailureException;

public class Francis extends Turbine
{
    @Override
    public DischargeResult discharge(double waterPressure, int timeInSeconds) throws TurbineFailureException
    {
        double waterDischarge = 0.0;
        double rotationalSpeed = 0.0;

        if (waterPressure > 300000)
        {
            throw new TurbineFailureException();
        }

        if (waterPressure <= 100000)
        {
            this.setEfficiencyPercentage(this.getEfficiencyPercentage());
            waterDischarge = (40 * waterPressure);
            rotationalSpeed = (timeInSeconds * 0.4 * 50);
            this.calculateHeat(waterDischarge);
        }

        else
        {
            this.setEfficiencyPercentage(this.getEfficiencyPercentage() - (this.getEfficiencyPercentage() * 0.02));
        }

        return new DischargeResult(waterDischarge, rotationalSpeed);
    }
}
