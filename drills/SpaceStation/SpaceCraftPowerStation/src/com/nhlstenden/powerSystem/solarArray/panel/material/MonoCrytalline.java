package com.nhlstenden.powerSystem.solarArray.panel.material;

import com.nhlstenden.powerSystem.solarArray.panel.PowerSystemFailureException;
import com.nhlstenden.powerSystem.solarArray.panel.SolarPanel;

public class MonoCrytalline extends SolarPanel
{
    @Override
    public double generatePower(double radiation, int timeInSeconds, int temperature) throws PowerSystemFailureException
    {
        double kWhGenerated = this.getTotalkWhGenerated();
        this.setEfficiencyPercentage((this.getEfficiencyPercentage() - 0.05) * timeInSeconds);

        if (timeInSeconds > 60 || radiation > 1500.0 || this.getEfficiencyPercentage() < 0.1)
        {
            throw new PowerSystemFailureException();
        }

        else if (temperature > 120)
        {
            kWhGenerated += (0.95 * radiation * timeInSeconds * 0.8) - (0.95 * radiation * timeInSeconds * 0.8 * 0.2);
        }

        else
        {
            kWhGenerated += (0.95 * radiation * timeInSeconds * 0.8);
        }

        return kWhGenerated;
    }
}
