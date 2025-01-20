package com.nhlstenden.appliance.podHolder;

public class NoMorePodException extends RuntimeException
{
    public NoMorePodException (String message)
    {
        super(message);
    }
}
