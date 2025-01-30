package com.nhlstenden.powerSystem.solarArray;

import com.nhlstenden.powerSystem.solarArray.panel.SolarPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SolarArray
{
    private List<SolarPanel> panels;

    private static final int MAX_RADIATION = 200;
    private static final int MIN_RADIATION = 1500;
    private static final int MIN_AMBIENT_TEMPERATURE = -100;
    private static final int MAX_AMBIENT_TEMPERATURE = 150;

    private ScheduledExecutorService temperatureChanges;
    private ScheduledExecutorService radiationChanges;

    private static final Logger log = Logger.getLogger(SolarArray.class.getName());

    public SolarArray ()
    {
        this.panels = new ArrayList<>();
    }

    public List<SolarPanel> getPanels ()
    {
        return panels;
    }

    public void setPanels (List<SolarPanel> panels)
    {
        this.panels = panels;
    }

    public void addPanel(SolarPanel panel)
    {
        this.panels.add(panel);
    }

    public static int getRadiation()
    {
        return (new Random().nextInt(MIN_RADIATION, MAX_RADIATION + 1));
    }

    public static int getAmbientTemperature()
    {
        return (new Random().nextInt(MIN_AMBIENT_TEMPERATURE, MAX_AMBIENT_TEMPERATURE));
    }



    public double run(int radiation, int timesInSeconds, int temperature)
    {
        CompletableFuture.runAsync(()->
        {
            radiationChanges.scheduleAtFixedRate(()->{
                synchronized (SolarArray.this)
                {
                    radiation = getRadiation();
                    log.info("Current radiation: " + radiation);
                }
            }, 0, 1000, TimeUnit.SECONDS);

            temperatureChanges.scheduleAtFixedRate(() -> {
                synchronized (SolarArray.this)
                {
                    temperature = getAmbientTemperature();
                    log.info("Current temperature: " + temperature);
                }
            }, 0, 1000, TimeUnit.SECONDS);

            for (SolarPanel panel : this.panels)
            {
                panel.generatePower(radiation, timesInSeconds, temperature);
            }
        });
    }
}
