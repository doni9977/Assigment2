package src;
import java.util.Iterator;

/**
 * A generic queue implementation using MyLinkedList.
 * Follows FIFO (First-In-First-Out) behavior.
 * @param <T> the type of elements in the queue
 */
public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> list; // Underlying storage

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /**
     * Adds an item to the rear of the queue.
     * @param item the element to enqueue
     */
    public void enqueue(T item) {
        list.add(item);
    }

    /**
     * Removes and returns the front item from the queue.
     * @return the front element
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.get(0);
        list.remove(0);
        return item;
    }

    /**
     * Returns the front item without removing it.
     * @return the front element
     * @throws IllegalStateException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of items in the queue.
     * @return the size of the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Provides an iterator to traverse the queue from front to rear.
     * @return an iterator over the queue elements
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}