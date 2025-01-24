package com.nhlstenden.appliance.thermometer;

public class ThermoResult
{
    private int temperature;

    public ThermoResult(int temperature)
    {
        this.temperature = temperature;
    }

    public TemperatureClassification getTemperatureLevel()
    {
        if (this.temperature < 10)
        {
            return TemperatureClassification.COLD;
        }
        else if (this.temperature < 50)
        {
            return TemperatureClassification.MEDIUM;
        }
        else
        {
            return TemperatureClassification.HOT;
        }
    }

    public void setTemperature (int temperature)
    {
        this.temperature = temperature;
    }

    @Override
    public String toString ()
    {
        return "Result \n" + "temperature = " + temperature;
    }
}
