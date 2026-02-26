package Projects.ElevatorSystem.models;

import Projects.ElevatorSystem.enums.DoorAction;
import Projects.ElevatorSystem.interfaces.Button;

public class DoorButton implements Button {
    private boolean status;
    private DoorAction action; // Store which action this button performs

    public DoorButton(boolean status, DoorAction action) {
        this.status = status;
        this.action = action;
    }

    public DoorAction getAction() {
        return action;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    @Override
    public boolean press() {
        // Buttons are usually momentary, so they just return true when pressed
        // Or, if it's a toggle (like 'Hold Door'):
        this.status = !this.status;
        return this.status;
    }
}