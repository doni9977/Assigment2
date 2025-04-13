package src;
import java.util.Iterator;

/**
 * A generic min-heap implementation using MyArrayList.
 * Maintains the heap property: parent <= children.
 * @param <T> the type of elements, must be comparable
 */
public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private final MyArrayList<T> heap; // Underlying storage

    /**
     * Constructs an empty min-heap.
     */
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    /**
     * Inserts an item into the heap and restores the heap property.
     * @param item the element to insert
     */
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    /**
     * Removes and returns the minimum element (root) from the heap.
     * @return the minimum element
     * @throws IllegalStateException if the heap is empty
     */
    public T deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    /**
     * Restores heap property by moving an element up.
     * @param index the index of the element to heapify
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    /**
     * Restores heap property by moving an element down.
     * @param index the index of the element to heapify
     */
    private void heapifyDown(int index) {
        int minChild;
        while (2 * index + 1 < heap.size()) {
            minChild = 2 * index + 1; // Left child
            if (minChild + 1 < heap.size() && heap.get(minChild + 1).compareTo(heap.get(minChild)) < 0) {
                minChild++; // Right child is smaller
            }
            if (heap.get(index).compareTo(heap.get(minChild)) <= 0) {
                break;
            }
            swap(index, minChild);
            index = minChild;
        }
    }

    /**
     * Swaps two elements in the heap.
     * @param i first index
     * @param j second index
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Checks if the heap is empty.
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Returns the number of elements in the heap.
     * @return the size of the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * Provides an iterator to traverse the heap (in array order).
     * @return an iterator over the heap elements
     */
    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }
}