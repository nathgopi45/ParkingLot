package com.thoughtWorks;

import com.thoughtWorks.parkingLot.FBIAgent.FBIAgent;
import com.thoughtWorks.parkingLot.ParkingLot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by user on 4/23/2015.
 */
public class FBIAgentTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private String NO_PARKIN_LOT_ASSIGNED = "no parking lot assigned";

    @Test
    public void testIfParkingLotIsInvalid() throws Exception
    {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(NO_PARKIN_LOT_ASSIGNED);
        ParkingLot parkingLot = null;
        FBIAgent fbiAgent = new FBIAgent(parkingLot);
    }


}
