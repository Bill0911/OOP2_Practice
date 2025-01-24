package com.nhlstenden.reservoir;

import com.nhlstenden.controlRoom.Status;
import com.nhlstenden.controlRoom.Statusable;

import java.util.Random;

public class Reservoir implements Statusable
{
    public static final double LOWER_MINIMUM_CAPACITY_PERCENTAGE = 30.0;
    private double waterCapacityInCubicMeters;
    private static final int CAPACITY_MAX = 10000;
    private static final int CAPACITY_MIN = 6000;

    public Reservoir ()
    {
        this.waterCapacityInCubicMeters = 0.0;
    }

    public double getWaterCapacityInCubicMeters ()
    {
        return waterCapacityInCubicMeters;
    }

    public void setWaterCapacityInCubicMeters (double waterCapacityInCubicMeters)
    {
        this.waterCapacityInCubicMeters = waterCapacityInCubicMeters;
    }

    public void addWater()
    {
        double water = (new Random().nextInt(CAPACITY_MIN, CAPACITY_MAX));
        this.setWaterCapacityInCubicMeters(water);
    }

    @Override
    public Status getStatus()
    {
        double waterLevelDanger = CAPACITY_MIN - (CAPACITY_MIN * LOWER_MINIMUM_CAPACITY_PERCENTAGE);

        if (this.getWaterCapacityInCubicMeters() < waterLevelDanger)
        {
            return Status.NEEDS_ATTENTION;
        }

        return Status.STABLE;
    }

    @Override
    public String toString ()
    {
        return "Reservoir\n" + "waterCapacityInCubicMeters=" + waterCapacityInCubicMeters;
    }
}

















