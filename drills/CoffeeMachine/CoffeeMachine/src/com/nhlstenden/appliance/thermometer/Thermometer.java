package com.nhlstenden.appliance.thermometer;

public class Thermometer
{
    private Measurable measurable;

    public String getResult(Measurable measurable)
    {
        ThermoResult result = new ThermoResult(measurable.getTemperature());

        return "I measured a temperature of " + measurable.getTemperature() + "Celsius";
    }
}
