package DesignPatterns.BridgePattern;

// Implementation Hierarchy: Engine interface (LLL)
interface Engine {
    void start();
}

// Concrete Implementors (LLL)
class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine starting with ignition");
    }
}

class DieselEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Diesel engine starting with ignition");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine starting with ignition");
    }
}

// Abstraction Hierarchy: Car (HLL)
abstract class Car {
    protected Engine engine;

    public Car(Engine e) {
        this.engine = e;
    }

    public abstract void drive();
}

// Refinde Abstraction: Sedan
class Sedan extends Car {
    public Sedan(Engine e) {
        super(e);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving a Sedan on the highway");
    }
}

// Refinde Abstraction: SUV
class SUV extends Car {
    public SUV(Engine e) {
        super(e);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving a SUV on the highway");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Creating Engine Implementations
        Engine petrol = new PetrolEngine();
        Engine diesel = new DieselEngine();
        Engine electric = new ElectricEngine();

        // Create Car abstractions, injecting Engine implementaions
        Car mySedan = new Sedan(petrol);
        Car mySUV = new SUV(electric);
        Car suv = new SUV(diesel);

        // Use the cars
        mySedan.drive();
        mySUV.drive();
        suv.drive();
    }
}
