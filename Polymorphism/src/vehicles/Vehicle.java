package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
        this.setTankCapacity(tankCapacity);
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected abstract void driving(double distance);

    protected abstract void refueling(double liters);
}
