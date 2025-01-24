package com.nhlstenden;

import com.nhlstenden.controlRoom.ControlRoom;
import com.nhlstenden.coolingSystem.CoolingSystem;
import com.nhlstenden.generator.Generator;
import com.nhlstenden.reservoir.Reservoir;
import com.nhlstenden.turbines.DischargeResult;
import com.nhlstenden.turbines.Turbine;

import javax.naming.ldap.Control;

public class PowerPlan
{
    private Reservoir reservoir;
    private Turbine turbine;
    private Generator generator;
    private CoolingSystem coolingSystem;
    private ControlRoom controlRoom;

    public PowerPlan()
    {
        this.controlRoom = new ControlRoom();

        this.reservoir = new Reservoir();
        this.controlRoom.addComponent(reservoir);

        this.generator = new Generator();
        this.controlRoom.addComponent(generator);

        this.coolingSystem = new CoolingSystem();
        this.controlRoom.addComponent(coolingSystem);
    }

    public Reservoir getReservoir ()
    {
        return reservoir;
    }

    public void setReservoir (Reservoir reservoir)
    {
        this.reservoir = reservoir;
    }

    public Turbine getTurbine ()
    {
        return turbine;
    }

    public void setTurbine (Turbine turbine)
    {
        this.turbine = turbine;
    }

    public Generator getGenerator ()
    {
        return generator;
    }

    public void setGenerator (Generator generator)
    {
        this.generator = generator;
    }

    public CoolingSystem getCoolingSystem ()
    {
        return coolingSystem;
    }

    public void setCoolingSystem (CoolingSystem coolingSystem)
    {
        this.coolingSystem = coolingSystem;
    }

    public ControlRoom getControlRoom ()
    {
        return controlRoom;
    }

    public void setControlRoom (ControlRoom controlRoom)
    {
        this.controlRoom = controlRoom;
    }

    public int run(double waterPressure, int timeInSeconds)
    {
        DischargeResult result = this.turbine.discharge(waterPressure, timeInSeconds);
        this.coolingSystem.coolTurbine(this.turbine.getHeat());

        return (int) this.generator.generateEnergy(result.getWaterDischarge());
    }
}
