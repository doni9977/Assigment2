package src;
import java.util.Iterator;

/**
 * A generic stack implementation using MyArrayList.
 * Follows LIFO (Last-In-First-Out) behavior.
 * @param <T> the type of elements in the stack
 */
public class MyStack<T> implements Iterable<T> {
    private MyArrayList<T> list; // Underlying storage

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Adds an item to the top of the stack.
     * @param item the element to push
     */
    public void push(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the top item from the stack.
     * @return the top element
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    /**
     * Returns the top item without removing it.
     * @return the top element
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     * @return the size of the stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Provides an iterator to traverse the stack from top to bottom.
     * @return an iterator over the stack elements
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                return list.get(index--);
            }
        };
    }
}