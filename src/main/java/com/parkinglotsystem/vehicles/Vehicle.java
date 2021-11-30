package com.parkinglotsystem.vehicles;

import com.parkinglotsystem.models.ParkingFloor;
import com.parkinglotsystem.models.ParkingTicket;

import java.util.ArrayList;

public interface Vehicle {
    String parkVehicle(ArrayList<ParkingFloor> floors, ParkingTicket tickets, String registrationNumber, String color);
}
