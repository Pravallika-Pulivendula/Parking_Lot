package com.parkinglotsystem.display;

import com.parkinglotsystem.models.ParkingFloor;

import java.util.ArrayList;

public class DisplayStrategy {
    private final Display display;

    public DisplayStrategy(Display display) {
        this.display = display;
    }

    public void displayCount(ArrayList<ParkingFloor> floors) {
        this.display.displayFreeCount(floors);
    }

    public void displayFreeSlots(ArrayList<ParkingFloor> floors) {
        this.display.displayFreeSlots(floors);
    }

    public void displayOccupiedSlots(ArrayList<ParkingFloor> floors) {
        this.display.displayOccupiedSlots(floors);
    }
}
