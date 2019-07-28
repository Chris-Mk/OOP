package vehicles;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double fuelRequired = super.getFuelConsumptionPerKm() * distance;

        if (super.getFuelQuantity() < fuelRequired) {
            throw new IllegalArgumentException("Bus needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - fuelRequired);
    }

    @Override
    public void refueling(double liters) {
        if (liters < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double refuelLiters = super.getFuelQuantity() + liters;
        if (refuelLiters > super.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(refuelLiters);
    }
}
