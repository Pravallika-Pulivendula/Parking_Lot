package com.parkinglotsystem;

import java.util.ArrayList;

public class ParkingFloor {
    public ArrayList<ParkingSlot> slots = new ArrayList<>();

    ParkingFloor(int noOfSlots) {
        for (int slot = 0; slot < noOfSlots; slot++)
            slots.add(new ParkingSlot());
    }

}
