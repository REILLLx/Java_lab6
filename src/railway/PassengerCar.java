package railway;

/**
 * Клас для представлення пасажирського вагона.
 */
public class PassengerCar extends RollingStock {
    private final int passengerCapacity;
    private final int baggageCapacity;

    public PassengerCar(int comfortLevel, int passengerCapacity, int baggageCapacity) {
        super("Пасажирський вагон", comfortLevel);
        if (passengerCapacity < 0 || baggageCapacity < 0) {
            throw new IllegalArgumentException("Місткість пасажирів і багажу не може бути від'ємною.");
        }
        this.passengerCapacity = passengerCapacity;
        this.baggageCapacity = baggageCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Пасажири: " + passengerCapacity + ", Багаж: " + baggageCapacity;
    }
}
