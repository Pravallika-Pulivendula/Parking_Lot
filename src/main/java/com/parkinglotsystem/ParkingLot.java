package com.parkinglotsystem;

import com.parkinglotsystem.display.DisplayBike;
import com.parkinglotsystem.display.DisplayCar;
import com.parkinglotsystem.display.DisplayContext;
import com.parkinglotsystem.display.DisplayTruck;
import com.parkinglotsystem.parkvehicles.*;

import java.util.ArrayList;

public class ParkingLot {
    private final int noOfFloors;
    private final int noOfSlots;
    ArrayList<ParkingFloor> floors = new ArrayList<>();
    Ticket tickets = new Ticket();
    ParkVehicleContext context;
    DisplayContext displayContext;

    ParkingLot(String parkingLotId, int noOfFloors, int noOfSlots) {
        this.noOfFloors = noOfFloors;
        this.noOfSlots = noOfSlots;
        for (int floor = 0; floor < noOfFloors; floor++) {
            this.floors.add(new ParkingFloor(this.noOfSlots));
        }
    }

    public void createParkingLot() {
        System.out.println("Created parking lot with " + this.noOfFloors + " floors and " + this.noOfSlots + " slots per floor");
    }

    public void parkVehicle(String vehicleType, String registrationNumber, String vehicleColor) {
        switch (vehicleType) {
            case "CAR" -> context = new ParkVehicleContext(new Car());
            case "BIKE" -> context = new ParkVehicleContext(new Bike());
            case "TRUCK" -> context = new ParkVehicleContext(new Truck());
            default -> throw new IllegalStateException("Unexpected value: " + vehicleType);
        }
        context.parkTheVehicleType(this.getFloorDetails(), tickets, registrationNumber, vehicleColor);
    }

    public void unParkVehicle(String ticketId) {
        ArrayList<String> unParkedVehicleDetails = tickets.removeTicketId(ticketId);
        if (unParkedVehicleDetails.size() != 0) {
            int floorNo = Integer.parseInt(unParkedVehicleDetails.get(2));
            int slotNo = Integer.parseInt(unParkedVehicleDetails.get(3));
            floors.get(floorNo).slots.get(slotNo).freeSlot();
            System.out.println("UnParked vehicle with Registration number: " + unParkedVehicleDetails.get(0) + " and Color: " + unParkedVehicleDetails.get(1));
        } else
            System.out.println("Invalid ticket");
    }


    public ArrayList<ParkingFloor> getFloorDetails() {
        return floors;
    }

    public DisplayContext getDisplayContext(String vehicleType) {
        switch (vehicleType) {
            case "CAR" -> displayContext = new DisplayContext(new DisplayCar());
            case "BIKE" -> displayContext = new DisplayContext(new DisplayBike());
            case "TRUCK" -> displayContext = new DisplayContext(new DisplayTruck());
            default -> throw new IllegalStateException("Unexpected value: " + vehicleType);
        }
        return displayContext;
    }

}
