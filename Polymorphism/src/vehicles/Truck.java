package vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + 1.6, tankCapacity);
    }

    @Override
    public void driving(double distance) {
        double fuelRequired = super.getFuelConsumptionPerKm() * distance;

        if (super.getFuelQuantity() < fuelRequired) {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        super.setFuelQuantity(super.getFuelQuantity() - fuelRequired);
    }

    @Override
    public void refueling(double liters) {
        if (liters < 1) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double refuelLiters = super.getFuelQuantity() + liters * .95;
        if (refuelLiters > super.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(refuelLiters);
    }
}
