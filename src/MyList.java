package src;
/**
 * Interface defining common operations for a generic list.
 * @param <T> the type of elements in the list
 */
public interface MyList<T> {
    void add(T item);       // Add an item to the end of the list
    void remove(int index); // Remove the item at the given index
    T get(int index);       // Get the item at the given index
    int size();             // Get the current size of the list
    boolean isEmpty();      // Check if the list is empty
}