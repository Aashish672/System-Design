package Projects.ElevatorSystem.models;

import Projects.ElevatorSystem.enums.*;
import Projects.ElevatorSystem.interfaces.Pannel;
import java.util.ArrayList;
import java.util.List;

public class OutsidePannel implements Pannel {
    private List<HallButton> hallButtons;

    public OutsidePannel() {
        hallButtons = new ArrayList<>();
        hallButtons.add(new HallButton(false, Direction.UP));
        hallButtons.add(new HallButton(false, Direction.DOWN));
        hallButtons.add(new HallButton(false, Direction.IDLE));
    }

    public void moveUp() {

    }

    public void moveDown() {

    }

    @Override
    public void someMethod() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
