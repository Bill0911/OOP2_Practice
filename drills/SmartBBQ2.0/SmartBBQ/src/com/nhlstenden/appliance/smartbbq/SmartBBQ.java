package com.nhlstenden.appliance.smartbbq;

import com.nhlstenden.appliance.thermometer.Measurable;
import com.nhlstenden.food.Food;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SmartBBQ implements Measurable
{
    private static final Logger log = Logger.getLogger(SmartBBQ.class.getName());
    private ScheduledExecutorService preHeatScheduler;
    private ScheduledExecutorService grillScheduler;
    private static final int TEMPERATURE_INCREMENT = 5;
    private static final int INTERVAL_MS = 1000;
    private static final int GRILL_CAPACITY = 10;


    private int currentTemperature;
    private int targetTemperature;
    private List<Food> foods;

    public SmartBBQ() {
        this.currentTemperature = 0;
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        if (this.foods.size() >= GRILL_CAPACITY)
        {
            throw new IllegalArgumentException("The grill is full");
        }
        this.foods.add(food);
    }

    @Override
    public int getTemperature ()
    {
        return currentTemperature;
    }

    public void setCurrentTemperature (int currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }

    public int getTargetTemperature ()
    {
        return targetTemperature;
    }

    public void setTargetTemperature (int targetTemperature)
    {
        this.targetTemperature = targetTemperature;
    }

    public List<Food> getFoods ()
    {
        return foods;
    }

    public void setFoods (List<Food> foods)
    {
        this.foods = foods;
    }

    public void turnOn(int targetTemperature)
    {
        this.targetTemperature = targetTemperature;
        this.preHeatScheduler = Executors.newScheduledThreadPool(1);
        this.preHeat();
    }

    private void preHeat()
    {
        CompletableFuture.runAsync(() -> {
            preHeatScheduler.scheduleAtFixedRate(() ->
            {
                synchronized (SmartBBQ.this) {
                    log.info("Preheating... Current temperature: " + currentTemperature + "°C, Target temperature: " + targetTemperature + "°C");
                    if (currentTemperature >= targetTemperature)
                    {
                        preHeatScheduler.shutdown();
                        log.info("SmartBBQ™ is preheated to " + targetTemperature + "°C. Ready for use!");
                    }
                    else
                    {
                        currentTemperature += TEMPERATURE_INCREMENT;
                        log.info("Current temperature: " + currentTemperature + "°C");
                    }
                }
            }, 0, 1, TimeUnit.SECONDS);
        });
    }

    public void startGrillSession(int temperature, int timeInSeconds)
    {
        if (this.foods.isEmpty())
        {
            log.info("No food items to grill.");
            return;
        }

        this.grillScheduler = Executors.newScheduledThreadPool(1);
        this.grillScheduler.scheduleAtFixedRate(() -> {
            synchronized (SmartBBQ.this)
            {
                boolean allFoodCooked = true;
                Iterator<Food> iterator = foods.iterator();
                while (iterator.hasNext())
                {
                    Food food = iterator.next();
                    if (food.getCurrentTanningPercentage() < 100)
                    {
                        food.grill(temperature, timeInSeconds);
                        allFoodCooked = false;
                    }
                    else
                    {
                        log.info(food.getClass().getName() + " is fully cooked. Please remove it from the grill.");
                        iterator.remove();
                    }
                }

                logCurrentTanningPercentages();

                if (allFoodCooked)
                {
                    grillScheduler.shutdown();
                    log.info("All food items are fully cooked. Grilling session complete.");
                    turnOff();
                }
            }
        }, 0, INTERVAL_MS, TimeUnit.MILLISECONDS);
    }

    public void turnOff()
    {
        this.currentTemperature = 0;

        if (this.preHeatScheduler != null)
        {
            this.preHeatScheduler.shutdown();
            this.preHeatScheduler = null;
        }
        if (this.grillScheduler != null)
        {
            this.grillScheduler.shutdown();
            this.grillScheduler = null;
        }
        log.info("SmartBBQ™ is turned off.");
    }

    private void logCurrentTanningPercentages()
    {
        for (Food food : foods)
        {
            log.info(food.getClass().getName() + " current tanning percentage: " + food.getCurrentTanningPercentage() + "%");
        }
    }
}


















