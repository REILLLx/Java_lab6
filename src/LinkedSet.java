import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import railway.*;

/**
 * Типізована колекція LinkedSet, що реалізує інтерфейс Set
 * та використовує однозв'язковий список як внутрішню структуру.
 *
 * @param <E> Тип елементів у колекції.
 */
public class LinkedSet<E extends RollingStock> implements Set<E> {

    /**
     * Внутрішній вузол однозв'язкового списку.
     */
    private class Node {
        E value;
        Node next;

        /**
         * Конструктор для створення вузла списку.
         *
         * @param value Значення вузла.
         * @param next  Посилання на наступний вузол.
         */
        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // Початок списку
    private int size;  // Розмір колекції

    /**
     * Порожній конструктор.
     * Створює порожню колекцію.
     */
    public LinkedSet() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Конструктор, що додає один елемент до колекції.
     *
     * @param element Елемент для додавання.
     */
    public LinkedSet(E element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що додає всі елементи з переданої колекції.
     *
     * @param collection Колекція для додавання.
     */
    public LinkedSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * Додає елемент до множини.
     *
     * @param element Елемент для додавання.
     * @return true, якщо елемент успішно додано; false, якщо елемент вже існує.
     */
    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }
        head = new Node(element, head);
        size++;
        return true;
    }

    /**
     * Видаляє елемент з множини.
     *
     * @param element Елемент для видалення.
     * @return true, якщо елемент успішно видалено; false, якщо елемент не знайдено.
     */
    @Override
    public boolean remove(Object element) {
        if (head == null) {
            return false;
        }
        if (head.value.equals(element)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value.equals(element)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Перевіряє, чи містить множина заданий елемент.
     *
     * @param element Елемент для перевірки.
     * @return true, якщо елемент присутній; false, якщо елемент відсутній.
     */
    @Override
    public boolean contains(Object element) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Повертає розмір множини.
     *
     * @return Кількість елементів у множині.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи є множина порожньою.
     *
     * @return true, якщо множина порожня; false, якщо множина не порожня.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Повертає ітератор для обходу елементів множини.
     *
     * @return Ітератор множини.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    /**
     * Очищає множину.
     * Видаляє всі елементи.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Додає всі елементи з колекції.
     *
     * @param collection Колекція для додавання.
     * @return true, якщо множина була змінена; false, якщо всі елементи вже були присутні.
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;
        for (E element : collection) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Перевіряє, чи містить множина всі елементи з колекції.
     *
     * @param collection Колекція для перевірки.
     * @return true, якщо всі елементи присутні; false, якщо хоча б один елемент відсутній.
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Видаляє всі елементи, які містяться в заданій колекції.
     *
     * @param collection Колекція елементів для видалення.
     * @return true, якщо хоча б один елемент було видалено; false, якщо нічого не було видалено.
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object element : collection) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Зберігає тільки ті елементи, які присутні в заданій колекції.
     *
     * @param collection Колекція елементів, які потрібно зберегти.
     * @return true, якщо множина була змінена; false, якщо множина не змінилася.
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (!collection.contains(current.value)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                modified = true;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return modified;
    }

    /**
     * Повертає масив об'єктів, що містяться в множині.
     *
     * @return Масив об'єктів.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            array[index++] = current.value;
        }
        return array;
    }

    /**
     * Повертає типізований масив об'єктів, що містяться в множині.
     *
     * @param array Вхідний масив.
     * @param <T>   Тип масиву.
     * @return Масив об'єктів.
     */
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        }
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            array[index++] = (T) current.value;
        }
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    /**
     * Повертає рядкове представлення множини.
     *
     * @return Рядок, що представляє множину.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.value).append(current.next != null ? ", " : "");
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
