package railway;

/**
 * Клас для представлення багажного вагона.
 */
public class BaggageCar extends RollingStock {
    private final int baggageCapacity;

    public BaggageCar(int comfortLevel, int baggageCapacity) {
        super("Багажний вагон", comfortLevel);
        if (baggageCapacity < 0) {
            throw new IllegalArgumentException("Місткість багажу не може бути від'ємною.");
        }
        this.baggageCapacity = baggageCapacity;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Багаж: " + baggageCapacity;
    }
}
