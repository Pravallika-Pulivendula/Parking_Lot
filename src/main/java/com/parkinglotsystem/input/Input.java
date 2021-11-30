package com.parkinglotsystem.input;

import com.parkinglotsystem.ParkingLot;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    ArrayList<String> input = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ArrayList<String> inputGenerator() {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("exit"))
                break;
            input.add(line);
        }
        return input;
    }
}

