package railway;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Клас для представлення потяга, що складається з вагонів.
 */
public class Train {
    private final List<RollingStock> cars;

    public Train() {
        this.cars = new ArrayList<>();
    }

    /**
     * Додає вагон до потяга.
     *
     * @param car Вагон для додавання.
     */
    public void addCar(RollingStock car) {
        if (car == null) {
            throw new IllegalArgumentException("Вагон не може бути null.");
        }
        cars.add(car);
    }

    /**
     * Повертає загальну кількість пасажирів у потязі.
     *
     * @return Кількість пасажирів.
     */
    public int getTotalPassengers() {
        int totalPassengers = 0;
        for (RollingStock car : cars) {
            if (car instanceof PassengerCar) {
                totalPassengers += ((PassengerCar) car).getPassengerCapacity();
            } else if (car instanceof SleepingCar) {
                totalPassengers += ((SleepingCar) car).getPassengerCapacity();
            }
        }
        return totalPassengers;
    }

    /**
     * Повертає загальну кількість багажу в потязі.
     *
     * @return Кількість багажу.
     */
    public int getTotalBaggage() {
        int totalBaggage = 0;
        for (RollingStock car : cars) {
            if (car instanceof PassengerCar) {
                totalBaggage += ((PassengerCar) car).getBaggageCapacity();
            } else if (car instanceof BaggageCar) {
                totalBaggage += ((BaggageCar) car).getBaggageCapacity();
            }
        }
        return totalBaggage;
    }

    /**
     * Сортує вагони за рівнем комфортності.
     */
    public void sortCarsByComfort() {
        cars.sort((car1, car2) -> Integer.compare(car2.getComfortLevel(), car1.getComfortLevel()));
    }

    /**
     * Знаходить вагон із заданим діапазоном пасажирів.
     *
     * @param min Мінімальна кількість пасажирів.
     * @param max Максимальна кількість пасажирів.
     * @return Список вагонів, що відповідають діапазону.
     */
    public List<RollingStock> findCarsByPassengerRange(int min, int max) {
        List<RollingStock> result = new ArrayList<>();
        for (RollingStock car : cars) {
            int passengers = 0;
            if (car instanceof PassengerCar) {
                passengers = ((PassengerCar) car).getPassengerCapacity();
            } else if (car instanceof SleepingCar) {
                passengers = ((SleepingCar) car).getPassengerCapacity();
            }
            if (passengers >= min && passengers <= max) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Потяг складається з вагонів:\n");
        for (RollingStock car : cars) {
            result.append(car).append("\n");
        }
        return result.toString();
    }
}
