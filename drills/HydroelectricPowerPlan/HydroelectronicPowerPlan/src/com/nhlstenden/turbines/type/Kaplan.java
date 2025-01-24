package com.nhlstenden.turbines.type;

import com.nhlstenden.turbines.DischargeResult;
import com.nhlstenden.turbines.Turbine;
import com.nhlstenden.turbines.TurbineFailureException;

public class Kaplan extends Turbine
{
    @Override
    public DischargeResult discharge(double waterPressure, int timeInSeconds) throws TurbineFailureException
    {
        double waterDischarge = 0.0;
        double rotationalSpeed = 0.0;

        if ((waterPressure > 200000 && timeInSeconds > 120) || (this.getEfficiencyPercentage() < 0.1))
        {
            throw new TurbineFailureException();
        }

        this.setEfficiencyPercentage(this.getEfficiencyPercentage() - ((this.getEfficiencyPercentage() * 0.05) * timeInSeconds));

        if (waterPressure <= 150000)
        {
            waterDischarge = ((waterPressure / 500) * timeInSeconds * 0.85);
            rotationalSpeed = (timeInSeconds * 2);
            this.calculateHeat(waterDischarge);
        }
        else
        {
            waterDischarge = (0.85 * ((waterPressure * 0.75) / timeInSeconds) * Math.sqrt(2.0) * timeInSeconds);
            rotationalSpeed = (waterPressure / 100);
            this.calculateHeat(waterDischarge);
        }

        return new DischargeResult(waterDischarge, rotationalSpeed);
    }
}
