# Parking Lot Assignment

A command-line application for the Parking Lot System.

### Problem Statement

A parking lot is an area where cars can be parked for a certain amount of time. A parking lot can have multiple floors with each floor having a different number of slots and each slot being suitable for different types of vehicles. 

### Requirements

- The functions that the parking lot system can do:
  - Create the parking lot.
  - Add floors to the parking lot.
  - Add a parking lot slot to any of the floors.
  - Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
  - Unparks a vehicle given the ticket id.
  - Displays the number of free slots per floor for a specific vehicle type.
  - Displays all the free slots per floor for a specific vehicle type.
  - Displays all the occupied slots per floor for a specific vehicle type.
  - Details about the Vehicles:
  - Every vehicle will have a type, registration number, and color.
- Different Types of Vehicles:
  - Car
  - Bike
  - Truck
- Details about the Parking Slots:
  - Each type of slot can park a specific type of vehicle.
  - No other vehicle should be allowed by the system.
  - Finding the first available slot should be based on:
    - The slot should be of the same type as the vehicle.
    - The slot should be on the lowest possible floor in the parking lot.
    - The slot should have the lowest possible slot number on the floor.
    - Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.
- Details about the Parking Lot Floors:
  - Numbered serially from 1 to n where n is the number of floors.
  - Might contain one or more parking lot slots of different types.
  - We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.
- Details about the Tickets:
  - The ticket id would be of the following format:
    - <parking_lot_id>_<floor_no>_<slot_no>
    - Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
    - We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.
    
### Input/Output Format
The code should strictly follow the input/output format and will be tested with provided test cases.

#### Input Format
Multiple lines with each line containing a command.

#### Possible commands:

- create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
- park_vehicle <vehicle_type> <reg_no> <color>
- unpark_vehicle <ticket_id>
- display <display_type> <vehicle_type>
- Possible values of display_type: free_count, free_slots, occupied_slots
- exit
Stop taking the input when you encounter the word exit.

### Output Format
Print output based on the specific commands as mentioned below.

- create_parking_lot <br/>
  Created parking lot with <no_of_floors> floors and <no_of_slots_per_floor> slots per floor

- park_vehicle <br/>
  Parked vehicle. Ticket ID: <ticket_id>
  Print "Parking Lot Full" if slot is not available for that vehicle type.

- unpark_vehicle <br/>
  Unparked vehicle with Registration Number: <reg_no> and Color: <color>
  Print "Invalid Ticket" if ticket is invalid or parking slot is not occupied.

- display free_count <vehicle_type> <br/>
  No. of free slots for <vehicle_type> on Floor <floor_no>: <no_of_free_slots>
  The above will be printed for each floor.

- display free_slots <vehicle_type> <br/>
  Free slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
  The above will be printed for each floor.

- display occupied_slots <vehicle_type> <br/>
  Occupied slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
  The above will be printed for each floor.

### Setup

I have used the Intellij IDEA for this application, You can use any other IDE of your choice.

To run the Java application in Intellij follow the below steps:

- To develop Java applications in IntelliJ IDEA, you need the Java SDK (JDK).

- If the necessary JDK is already defined in IntelliJ IDEA, select it from the Project SDK list.

- If the JDK is installed on your computer, but not defined in the IDE, select Add JDK and specify the path to the JDK home directory (for example, /Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk).

- If you don't have the necessary JDK on your computer, select Download JDK. In the next dialog, specify the JDK vendor (for example, OpenJDK), version, change the installation path if required, and click Download.


### Run the application

- Clone the application, open it in Intellij. 
  ```
  git clone https://github.com/Pravallika-Pulivendula/ParkingLot
  ```

- Running the application
  ```
  Ctrl + R
  ```



