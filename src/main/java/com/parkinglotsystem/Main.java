package com.parkinglotsystem;

import com.parkinglotsystem.display.DisplayStrategy;
import com.parkinglotsystem.enums.DisplayType;
import com.parkinglotsystem.enums.InputCommands;
import com.parkinglotsystem.enums.VehicleType;
import com.parkinglotsystem.models.Input;
import com.parkinglotsystem.services.ParkingLot;

public class Main {

    public static void main(String[] args) {
        Input inputData = new Input();
        DisplayStrategy displayContext;
        ParkingLot parkingLot = null;

        for (String string : inputData.inputGenerator()) {
            String[] input;
            input = string.split(" ");
            switch (InputCommands.valueOf(input[0])) {
                case create_parking_lot -> {
                    parkingLot = ParkingLot.getInstance(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                    parkingLot.createParkingLot();
                }
                case park_vehicle -> {
                    if(parkingLot == null) throw new NullPointerException("Create parking lot");
                    parkingLot.parkVehicle(VehicleType.valueOf(input[1]), input[2], input[3]);
                }
                case unpark_vehicle -> {
                    if(parkingLot == null) throw new NullPointerException("Create parking lot");
                    System.out.println(parkingLot.unParkVehicle(input[1]));
                }
                case display -> {
                    if(parkingLot == null) throw new NullPointerException("Create parking lot");
                    displayContext = parkingLot.getDisplayContext(VehicleType.valueOf(input[2]));
                    switch (DisplayType.valueOf(input[1])) {
                        case free_count -> displayContext.displayCount(parkingLot.getFloorDetails());
                        case free_slots -> displayContext.displayFreeSlots(parkingLot.getFloorDetails());
                        case occupied_slots -> displayContext.displayOccupiedSlots(parkingLot.getFloorDetails());
                        default -> System.out.println("Enter valid display method");
                    }
                }
                default -> throw new IllegalStateException("Enter valid command " + input[0]);
            }
        }
    }
}
