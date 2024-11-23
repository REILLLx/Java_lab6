import railway.*;
import java.util.Arrays;

/**
 * Головний клас програми для тестування LinkedSet з RollingStock.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Створення порожнього LinkedSet
            LinkedSet<RollingStock> set = new LinkedSet<>();

            // Додавання одного елемента
            set.add(new PassengerCar(3, 50, 20));

            // Додавання множини елементів
            LinkedSet<RollingStock> set2 = new LinkedSet<>(Arrays.asList(
                    new SleepingCar(4, 20),
                    new BaggageCar(2, 100)
            ));

            set.addAll(set2);

            // Виведення результатів
            System.out.println("Елементи множини:");
            System.out.println(set);

            // Перевірка операцій
            System.out.println("\nМістить елемент? " + set.contains(new PassengerCar(3, 50, 20)));
            System.out.println("Розмір множини: " + set.size());

            // Видалення елементу
            set.remove(new PassengerCar(3, 50, 20));
            System.out.println("\nПісля видалення:");
            System.out.println(set);

        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        }
    }
}
