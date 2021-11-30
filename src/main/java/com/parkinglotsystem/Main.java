package com.parkinglotsystem;

import com.parkinglotsystem.display.DisplayContext;
import com.parkinglotsystem.input.Input;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        ParkingLot parkingLot = null;
        DisplayContext displayContext;

        for (String string : input.inputGenerator()) {
            String[] command;
            command = string.split(" ");
            switch (command[0]) {
                case "create_parking_lot" -> {
                    parkingLot = new ParkingLot(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                    parkingLot.createParkingLot();
                }
                case "park_vehicle" -> {
                    if (parkingLot != null) parkingLot.parkVehicle(command[1], command[2], command[3]);
                    else System.out.println("Create parking lot first!");
                }
                case "unpark_vehicle" -> {
                    if (parkingLot != null) parkingLot.unParkVehicle(command[1]);
                    else System.out.println("Create parking lot first!");
                }
                case "display" -> {
                    if (parkingLot != null) {
                        displayContext = parkingLot.getDisplayContext(command[2]);
                        switch (command[1]) {
                            case "free_count" -> displayContext.displayCount(parkingLot.getFloorDetails());
                            case "free_slots" -> displayContext.displayFreeSlots(parkingLot.getFloorDetails());
                            case "occupied_slots" -> displayContext.displayOccupiedSlots(parkingLot.getFloorDetails());
                            default -> System.out.println("Enter valid display method");
                        }
                    } else
                        System.out.println("Create parking lot first!");
                }
                default -> throw new IllegalStateException("Unexpected value: " + command[0]);
            }
        }
    }
}
