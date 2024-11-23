package railway;

/**
 * Клас для представлення пасажирського вагона.
 */
public class PassengerCar extends RollingStock {
    private final int passengerCapacity;
    private final int baggageCapacity;

    /**
     * Конструктор для створення пасажирського вагона.
     *
     * @param comfortLevel      Рівень комфортності (від 1 до 5).
     * @param passengerCapacity Кількість пасажирів, які можуть розміститися у вагоні.
     * @param baggageCapacity   Максимальна кількість багажу, яку можна розмістити у вагоні.
     * @throws IllegalArgumentException якщо місткість пасажирів або багажу є від'ємною.
     */
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
