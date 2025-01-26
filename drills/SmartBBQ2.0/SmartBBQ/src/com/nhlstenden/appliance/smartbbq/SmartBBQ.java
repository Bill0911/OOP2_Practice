package com.nhlstenden.appliance.smartbbq;

import com.nhlstenden.appliance.thermometer.Measurable;
import com.nhlstenden.food.Food;

import java.util.*;
import java.util.logging.Logger;

public class SmartBBQ implements Measurable
{
    private static final Logger log = Logger.getLogger(SmartBBQ.class.getName());
    private static final int TEMPERATURE_INCREMENT = 5;
    private static final int INTERVAL_MS = 1000;
    private static final int GRILL_CAPACITY = 10;


    private Timer preheatTimer;
    private Timer grillTimer;
    private int currentTemperature;
    private int targetTemperature;
    private List<Food> foods;

    public SmartBBQ() {
        this.currentTemperature = 0; // Assuming starting temperature is 0°C
        this.foods = new ArrayList<>();
    }

    public void turnOn(int targetTemperature) {
        this.targetTemperature = targetTemperature;
        this.preHeat();
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

    private class PreHeatTask extends TimerTask {
        @Override
        public void run() {
            synchronized (SmartBBQ.this) {
                if (currentTemperature >= targetTemperature) {
                    preheatTimer.cancel();
                    log.info("SmartBBQ™ is preheated to " + targetTemperature + "°C. Ready for use!");
                } else {
                    currentTemperature += TEMPERATURE_INCREMENT;
                    log.info("Current temperature: " + currentTemperature + "°C");
                }
            }
        }
    }

    private void preHeat() {
        this.preheatTimer = new Timer();
        preheatTimer.scheduleAtFixedRate(new PreHeatTask(), 0, INTERVAL_MS);
    }

    public void addFood(Food food) {
        if (this.foods.size() >= GRILL_CAPACITY) {
            throw new IllegalArgumentException("The grill is full");
        }
        this.foods.add(food);
    }

    public void startGrillSession(int temperature, int timeInSeconds) {
        if (this.foods.isEmpty()) {
            log.info("No food items to grill.");
            return;
        }

        this.turnOn(temperature);

        this.grillTimer = new Timer();
        this.grillTimer.scheduleAtFixedRate(new GrillTask(temperature, timeInSeconds), 0, INTERVAL_MS);
    }

    private class GrillTask extends TimerTask {
        private int temperature;
        private int timeInSeconds;

        public GrillTask(int temperature, int timeInSeconds) {
            this.temperature = temperature;
            this.timeInSeconds = timeInSeconds;
        }

        @Override
        public void run() {
            synchronized (SmartBBQ.this) {
                boolean allFoodCooked = true;
                Iterator<Food> iterator = foods.iterator();
                while (iterator.hasNext()) {
                    Food food = iterator.next();
                    if (food.getCurrentTanningPercentage() < 100) {
                        food.grill(temperature, timeInSeconds);
                        allFoodCooked = false;
                    } else {
                        log.info(food.getClass().getName() + " is fully cooked. Please remove it from the grill.");
                        iterator.remove();
                    }
                }

                logCurrentTanningPercentages();

                if (allFoodCooked) {
                    grillTimer.cancel();
                    log.info("All food items are fully cooked. Grilling session complete.");
                    turnOff();
                }
            }
        }
    }

    public void turnOff() {
        this.currentTemperature = 0;
        if (this.preheatTimer != null) {
            this.preheatTimer.cancel();
            this.preheatTimer = null;
        }
        if (this.grillTimer != null) {
            this.grillTimer.cancel();
            this.grillTimer = null;
        }
        log.info("SmartBBQ™ is turned off.");
    }

    private void logCurrentTanningPercentages() {
        for (Food food : foods) {
            log.info(food.getClass().getName() + " current tanning percentage: " + food.getCurrentTanningPercentage() + "%");
        }
    }
}


















