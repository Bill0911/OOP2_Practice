package com.nhlstenden.powerSystem.thermoControlUnit;

public class ThermoControlUnit
{
    public double regulateTemperature(double excessPower, int currentTemperature)
    {
        return currentTemperature - excessPower * 0.2;
    }
}
