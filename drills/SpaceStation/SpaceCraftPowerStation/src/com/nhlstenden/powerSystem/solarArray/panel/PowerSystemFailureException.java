package com.nhlstenden.powerSystem.solarArray.panel;

public class PowerSystemFailureException extends RuntimeException
{
    public PowerSystemFailureException ()
    {
        super("Oops it does not generate power");
    }
}
