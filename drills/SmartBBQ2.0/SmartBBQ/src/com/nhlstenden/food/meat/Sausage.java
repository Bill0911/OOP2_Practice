package com.nhlstenden.food.meat;

public class Sausage extends Meat
{
    public Sausage()
    {
        super(MeatType.VARKEN, 80, 0.05);
    }

    @Override
    public String toString ()
    {
        return "Sausage";
    }
}
