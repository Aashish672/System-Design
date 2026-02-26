package Projects.ElevatorSystem.models;

import Projects.ElevatorSystem.enums.*;
import Projects.ElevatorSystem.interfaces.*;
import java.util.ArrayList;
import java.util.List;

// Remember to rename Pannel.java -> Panel.java and change this
public class InsidePannel implements Pannel {
    private List<ElevatorButton> elevatorButtonList;
    private List<DoorButton> doorButtons;

    public InsidePannel() {
        elevatorButtonList = new ArrayList<>();
        doorButtons = new ArrayList<>();

        // CRITICAL FIX: Loop over the *actual* number of floors
        // This avoids the ArrayIndexOutOfBoundsException
        for (FloorNumber floor : FloorNumber.values()) {
            elevatorButtonList.add(new ElevatorButton(false, floor));
        }

        // CRITICAL FIX: Loop over the *actual* number of door actions
        // (This assumes you fixed DoorAction.java as I mentioned in the first review)
        for (DoorAction action : DoorAction.values()) {
            doorButtons.add(new DoorButton(false, action));
        }
    }

    public boolean pressFloorButton(int floorNumber) {
        // Use ordinal() to get the index from the enum
        return elevatorButtonList.get(floorNumber).press();
    }

    public boolean pressDoorButton(int doorNumber) {
        return doorButtons.get(doorNumber).press();
    }

    // This method was missing from your interface,
    // but your ElevatorSystem class needs it.
    @Override
    public void someMethod() {
        // Implement this
    }
}