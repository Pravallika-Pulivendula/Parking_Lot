package com.parkinglotsystem.vehicles;

import com.parkinglotsystem.models.ParkingFloor;
import com.parkinglotsystem.models.ParkingSlot;
import com.parkinglotsystem.models.ParkingTicket;


public class Truck implements Vehicle {
    @Override
    public String getTicketIfSlotFree(ParkingFloor eachFloor, ParkingTicket tickets, String registrationNumber, String color, int floor) {
        String ticketId = "";
        for (int eachSlot = 0; eachSlot < 1; eachSlot++) {
            ParkingSlot slotPerFloor = eachFloor.getSlots().get(eachSlot);
            if (slotPerFloor.isSlotEmpty()) {
                slotPerFloor.occupySlot();
                ticketId = tickets.generateTicketId("PR1234", registrationNumber, color, floor + 1, eachSlot + 1);
                return ticketId;
            }
        }
        return ticketId;
    }

}
