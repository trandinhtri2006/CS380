// Tri Tony Tran
public interface MotorVehicle {
    void build();
}

public static class Motorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Motorcycle");
    }
}

public static class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}

public abstract static class MotorVehicleFactory {
    public MotorVehicle create() {
        MotorVehicle vehicle = createMotorVehicle();
        vehicle.build();
        return vehicle;
    }
    protected abstract MotorVehicle createMotorVehicle();
}

public static class MotorcycleFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}

public static class CarFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}

public static void main(String[] args) {
    MotorVehicleFactory motorcycleFactory = new MotorcycleFactory();
    MotorVehicleFactory carFactory = new CarFactory();

    System.out.println("Creating a Motorcycle:");
    MotorVehicle motorcycle = motorcycleFactory.create();

    System.out.println("\nCreating a Car:");
    MotorVehicle car = carFactory.create();
}

