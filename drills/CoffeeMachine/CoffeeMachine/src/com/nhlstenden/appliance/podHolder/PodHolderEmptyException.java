package com.nhlstenden.appliance.podHolder;

public class PodHolderEmptyException extends RuntimeException
{
    public PodHolderEmptyException ()
    {
        super("The holder is empty");
    }
}
