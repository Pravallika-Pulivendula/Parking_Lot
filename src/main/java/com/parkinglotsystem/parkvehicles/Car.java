package com.parkinglotsystem.parkvehicles;

import com.parkinglotsystem.ParkingFloor;
import com.parkinglotsystem.ParkingSlot;
import com.parkinglotsystem.Ticket;

import java.util.ArrayList;

public class Car implements ParkVehicle {
    @Override
    public void parkVehicle(ArrayList<ParkingFloor> floors, Ticket tickets, String registrationNumber, String color) {
        String ticketId = "";
        outerLoop:
        for (int floor = 0; floor < floors.size(); floor++) {
            ParkingFloor eachFloor = floors.get(floor);
            for (int eachSlot = 3; eachSlot < eachFloor.slots.size(); eachSlot++) {
                ParkingSlot slotPerFloor = eachFloor.slots.get(eachSlot);
                if (slotPerFloor.isSlotEmpty()) {
                    slotPerFloor.occupySlot();
                    ticketId = tickets.generateTicketId("PR1234", registrationNumber, color, floor + 1, eachSlot + 1);
                    break outerLoop;
                }
            }
        }
        if (ticketId.length() == 0) System.out.println("Parking Lot Full");
        else System.out.println("Parked vehicle. Ticket ID: " + ticketId);
    }
}