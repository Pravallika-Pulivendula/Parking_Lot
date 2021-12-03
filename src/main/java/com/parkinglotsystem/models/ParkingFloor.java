package com.parkinglotsystem.models;

import java.util.ArrayList;

public class ParkingFloor {
    private final ArrayList<ParkingSlot> slots = new ArrayList<>();

    public ParkingFloor(int noOfSlots) {
        for (int slot = 0; slot < noOfSlots; slot++)
            slots.add(new ParkingSlot());
    }

    public ArrayList<ParkingSlot> getSlots()
    {
        return slots;
    }
}
