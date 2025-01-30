package com.nhlstenden.powerSystem.solarArray.panel.material;

import com.nhlstenden.powerSystem.solarArray.panel.PowerSystemFailureException;
import com.nhlstenden.powerSystem.solarArray.panel.SolarPanel;

public class PolyCrystalline extends SolarPanel
{
    @Override
    public double generatePower(double radiation, int timeInSeconds, int temperature) throws PowerSystemFailureException
    {
        this.setEfficiencyPercentage(this.getEfficiencyPercentage() - (0.00001 * radiation * timeInSeconds + 0.0005));
        double kwhGenerated = this.getTotalkWhGenerated();

        if (temperature < -80 || getEfficiencyPercentage() < 0.05)
        {
            throw new PowerSystemFailureException();
        }

        else if (temperature <= -50)
        {
            this.setTotalkWhGenerated(kwhGenerated);
        }

        else
        {
            kwhGenerated += (radiation * 0.6 * timeInSeconds * 0.85);
        }

        this.setTotalkWhGenerated(kwhGenerated);
        return kwhGenerated;
    }
}
