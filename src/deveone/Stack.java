package deveone;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {
    private final Class<T> parameterTypeClass;
    private int capacity;
    private T[] array;
    private int elementsAmount = 0;

    public Stack(Class<T> parameterTypeClass, int capacity) {
        this.parameterTypeClass = parameterTypeClass;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public Stack(Class<T> parameterTypeClass) {
        this.parameterTypeClass = parameterTypeClass;
        this.capacity = 10;
        array = (T[]) new Object[capacity];
    }

    public T pop() {
        elementsAmount--;
        T element = array[elementsAmount];
        array[elementsAmount] = null;

        trimToSize();

        return element;
    }

    public T peek() {
        return array[elementsAmount - 1];
    }

    public void push(T element) {
        ensureCapacity();

        array[elementsAmount] = element;

        elementsAmount++;
    }

    public boolean empty() {
        return elementsAmount == 0;
    }

    public int search(T element) {
        if (element == null) {
            return -1;
        } else {
            for (int i = capacity - 1; i >= 0; i--) {
                if (element.equals(array[i]))
                    return i;
            }
        }

        return -1;
    }

    private void ensureCapacity() {
        if (elementsAmount + 1 > capacity) {
            int newCapacity = capacity * 2;
            changeArrSize(newCapacity);
            capacity = newCapacity;
        }
    }

    private void trimToSize() {
        int newCapacity = capacity / 2;

        if (newCapacity > elementsAmount) {
            capacity = newCapacity;
            changeArrSize(newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeArrSize(int newCapacity) {
        T[] newArray = (T[]) Array.newInstance(parameterTypeClass, newCapacity);
        System.out.println(newArray.length);

        System.arraycopy(array, 0, newArray, 0, capacity);

        capacity = newCapacity;
        array = newArray;
    }

    @Override
    public String toString() {
        return "Stack{" + Arrays.toString(array) + '}';
    }
}
