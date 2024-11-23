package railway;

/**
 * Клас для представлення спального вагона.
 */
public class SleepingCar extends RollingStock {
    private final int passengerCapacity;

    public SleepingCar(int comfortLevel, int passengerCapacity) {
        super("Спальний вагон", comfortLevel);
        if (passengerCapacity < 0) {
            throw new IllegalArgumentException("Місткість пасажирів не може бути від'ємною.");
        }
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Пасажири: " + passengerCapacity;
    }
}
