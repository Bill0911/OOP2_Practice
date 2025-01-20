package com.nhlstenden.appliance.coffeeMachine;

import com.nhlstenden.appliance.thermometer.Measurable;
import com.nhlstenden.drink.coffeePods.CoffeePod;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CoffeeMachine extends TimerTask implements Measurable
{
    private int temperature;
    private List<CoffeePod> coffeePods;
    private Timer timer;

    public CoffeeMachine ()
    {
        this.temperature = 0;
        this.coffeePods = new ArrayList<>();
    }

    public int getTemperature ()
    {
        return temperature;
    }

    @Override
    public int measureTemperature()
    {
        return this.temperature;
    }

    public void setTemperature (int temperature)
    {
        if (temperature > 95)
        {
            this.temperature = 95;
            return;
        }

        if (temperature < 60)
        {
            this.temperature = 60;
            return;
        }
        this.temperature = temperature;
    }

    public List<CoffeePod> getCoffeePods ()
    {
        return coffeePods;
    }

    public void setCoffeePods (List<CoffeePod> coffeePods)
    {
        this.coffeePods = coffeePods;
    }

    public void addDrink(CoffeePod pod)
    {
        if (this.coffeePods.size() > 6)
        {
            throw new IllegalArgumentException("The coffee machine is full");
        }

        this.coffeePods.add(pod);
    }

    public void turnOn(int brewingTemperature)
    {
        this.temperature = brewingTemperature;
        this.timer = new Timer();
        this.timer.schedule(this,0, 10000);
    }

    public void turnOff()
    {
        this.temperature = 0;
        this.timer.cancel();
        this.timer = null;
    }

    @Override
    public void run()
    {
        for (CoffeePod pod : this.coffeePods)
        {
            pod.startMakingCoffee(10, this.temperature);
        }
    }
}
