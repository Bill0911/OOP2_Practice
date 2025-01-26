package com.nhlstenden.food.meat;

public class Hamburger extends Meat
{
    public Hamburger()
    {
        super(MeatType.KOE, 100, 0.06);
    }

    @Override
    public String toString ()
    {
        return "Hamburger";
    }
}
