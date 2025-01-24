package com.nhlstenden.FrancisTurbine;
import com.nhlstenden.turbines.TurbineFailureException;
import com.nhlstenden.turbines.type.Francis;
import com.nhlstenden.turbines.type.Kaplan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrancisTurbineTest
{
    @Test void test_WaterDischarge_ShouldThrowException() throws TurbineFailureException
    {
        Francis francis = new Francis();

        francis.discharge(301000, 100);
        assertThrows(TurbineFailureException.class, ()-> francis.discharge(301000, 100));
    }

    @Test void test_WaterDischarge_ShouldNotThrowException() throws TurbineFailureException
    {
        Francis francis = new Francis();

        francis.discharge(299000, 100);
        assertDoesNotThrow(()-> francis.discharge(299000, 100));
    }

    @Test void test_efficiencyPercentage() throws TurbineFailureException
    {
        Francis francis = new Francis();

        francis.discharge(299000, 100);
        double percentageRemainAfterDecline = 100 - (100 * 0.02);


        assertEquals(percentageRemainAfterDecline, francis.getEfficiencyPercentage()); // first test should get declined

        francis.discharge(99000, 90);
        assertEquals(percentageRemainAfterDecline, francis.getEfficiencyPercentage()); // second test should not get decline

        double percentageRemainAfterDecline1 = 100 - (100 * 0.02 * 2);
        francis.discharge(101000, 100);
        assertEquals(percentageRemainAfterDecline1, francis.getEfficiencyPercentage()); // third test should get decline
    }
}
