package com.nhlstenden.appliance.thermometer;

public class ThermoResult
{
    private int temperature;

    public ThermoResult(int temperature)
    {
        this.temperature = temperature;
    }

    public int getTemperature ()
    {
        return temperature;
    }

    public void setTemperature (int temperature)
    {
        this.temperature = temperature;
    }

    public TemperatureClassification getTemperatureLevel()
    {
        if (temperature <= 10)
        {
            return TemperatureClassification.COLD;
        }
        else if (temperature <= 70)
        {
            return TemperatureClassification.MEDIUM;
        }
        else
        {
            return TemperatureClassification.HOT;
        }
    }

    @Override
    public String toString ()
    {
        return "I measure a temperature of " + temperature + " degree Celsius";
    }
}
