package com.everest.parkinglotsystem.vehicles;

import com.everest.parkinglotsystem.models.ParkingFloor;
import com.everest.parkinglotsystem.models.ParkingSlot;
import com.everest.parkinglotsystem.models.ParkingTicket;

import java.util.ArrayList;

public interface Vehicle {
    String parkVehicle(ArrayList<ParkingFloor> floors, ParkingTicket tickets, String registrationNumber, String color);
}
