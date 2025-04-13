package src;
import java.util.Iterator;

/**
 * A generic dynamic array-based list implementation.
 * Supports adding, removing, and accessing elements with automatic resizing.
 * @param <T> the type of elements stored in the list
 */
public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private Object[] array; // Internal storage for elements
    private int size;      // Number of elements in the list
    private static final int INITIAL_CAPACITY = 10; // Default initial capacity

    /**
     * Constructs an empty ArrayList with default capacity.
     */
    public MyArrayList() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds an item to the end of the list, resizing if necessary.
     * @param item the element to add
     */
    @Override
    public void add(T item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }

    /**
     * Removes the element at the specified index, shifting subsequent elements left.
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null; // Clear last element
    }

    /**
     * Retrieves the element at the specified index.
     * @param index the index of the element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Returns the number of elements in the list.
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Updates the element at the specified index.
     * @param index the index to update
     * @param item the new element
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    /**
     * Doubles the capacity of the internal array when full.
     */
    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * Validates the index for access or modification.
     * @param index the index to check
     * @throws IndexOutOfBoundsException if index is invalid
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Provides an iterator to traverse the list.
     * @return an iterator over the list elements
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return (T) array[current++];
            }
        };
    }
}