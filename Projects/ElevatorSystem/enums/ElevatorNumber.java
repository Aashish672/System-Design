package Projects.ElevatorSystem.enums;

public enum ElevatorNumber {
    ONE(1), TWO(2);

    private int value;

    ElevatorNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}