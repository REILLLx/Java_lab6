package railway;

/**
 * Узагальнений клас для представлення рухомого складу залізничного транспорту.
 */
public abstract class RollingStock {
    private final String type;
    private final int comfortLevel;

    /**
     * Конструктор для створення об'єкта рухомого складу.
     *
     * @param type         Тип рухомого складу (наприклад, "Пасажирський вагон").
     * @param comfortLevel Рівень комфортності (від 1 до 5, де 5 - найвищий комфорт).
     */
    public RollingStock(String type, int comfortLevel) {
        if (comfortLevel < 1 || comfortLevel > 5) {
            throw new IllegalArgumentException("Рівень комфортності повинен бути від 1 до 5.");
        }
        this.type = type;
        this.comfortLevel = comfortLevel;
    }

    public String getType() {
        return type;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public String toString() {
        return "Тип: " + type + ", Рівень комфортності: " + comfortLevel;
    }
}
