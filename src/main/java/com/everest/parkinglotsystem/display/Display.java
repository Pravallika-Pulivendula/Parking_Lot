package com.everest.parkinglotsystem.display;

import com.everest.parkinglotsystem.models.ParkingFloor;

import java.util.ArrayList;

public interface Display {
    void displayFreeCount(ArrayList<ParkingFloor> floors);

    void displayFreeSlots(ArrayList<ParkingFloor> floors);

    void displayOccupiedSlots(ArrayList<ParkingFloor> floors);
}
