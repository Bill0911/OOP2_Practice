package com.nhlstenden.appliance.fridge;

public class FridgeIsEmptyException extends RuntimeException
{
    public FridgeIsEmptyException ()
    {
        super("The fridge is empty");
    }
}
