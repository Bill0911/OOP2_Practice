package com.nhlstenden.controlRoom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControlRoom
{
    private Set<Statusable> statusables;

    public ControlRoom()
    {
        this.statusables = new HashSet<>();
    }

    public void addComponent(Statusable statusable)
    {
        this.statusables.add(statusable);
    }

    public Set<Statusable> getStatusables ()
    {
        return statusables;
    }

    public void setStatusables (Set<Statusable> statusables)
    {
        this.statusables = statusables;
    }

    public boolean isHydroelectricStable()
    {
        for (Statusable statusable : this.statusables)
        {
            if (statusable.getStatus().equals(Status.UNSTABLE))
            {
                return false;
            }
        }

        return true;
    }
}
