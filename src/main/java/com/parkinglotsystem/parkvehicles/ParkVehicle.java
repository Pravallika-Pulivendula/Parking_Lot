package com.parkinglotsystem.parkvehicles;

import com.parkinglotsystem.ParkingFloor;
import com.parkinglotsystem.Ticket;

import java.util.ArrayList;

public interface ParkVehicle {
    void parkVehicle(ArrayList<ParkingFloor> floors, Ticket tickets, String registrationNumber, String color);
}
