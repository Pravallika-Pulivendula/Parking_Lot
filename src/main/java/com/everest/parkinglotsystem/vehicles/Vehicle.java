package com.everest.parkinglotsystem.vehicles;

import com.everest.parkinglotsystem.models.ParkingFloor;
import com.everest.parkinglotsystem.models.Ticket;

import java.util.ArrayList;

public interface Vehicle {
    String parkVehicle(ArrayList<ParkingFloor> floors, Ticket tickets, String registrationNumber, String color);
}
