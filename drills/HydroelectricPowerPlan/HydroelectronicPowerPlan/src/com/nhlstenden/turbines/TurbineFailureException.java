package com.nhlstenden.turbines;

public class TurbineFailureException extends RuntimeException
{
    public TurbineFailureException ()
    {
        super("Hell no, we got a breakdown");
    }
}
