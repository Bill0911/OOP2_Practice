package com.nhlstenden.appliance.thermometer;

public class Thermometer
{
    public ThermoResult measure(Measurable measurable)
    {
        return new ThermoResult(measurable.getTemperature());
    }
}
