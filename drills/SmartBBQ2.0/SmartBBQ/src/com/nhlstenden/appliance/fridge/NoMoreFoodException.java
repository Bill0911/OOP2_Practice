package com.nhlstenden.appliance.fridge;

public class NoMoreFoodException extends RuntimeException
{
    public NoMoreFoodException (String message)
    {
        super("Hell no, we run out of ");
    }
}
