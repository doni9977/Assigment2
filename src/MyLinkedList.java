package src;
import java.util.Iterator;

/**
 * A generic doubly linked list implementation.
 * Supports efficient insertion and deletion at both ends.
 * @param <T> the type of elements stored in the list
 */
public class MyLinkedList<T> implements MyList<T>, Iterable<T> {
    private src.MyLinkedList.Node head; // First node in the list
    private src.MyLinkedList.Node tail; // Last node in the list
    private int size;  // Number of elements

    /**
     * Internal node class for the doubly linked list.
     */
    private class Node {
        T data;        // Element stored in the node
        src.MyLinkedList.Node next;     // Reference to the next node
        src.MyLinkedList.Node prev;     // Reference to the previous node

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an item to the end of the list.
     * @param item the element to add
     */
    @Override
    public void add(T item) {
        src.MyLinkedList.Node newNode = new src.MyLinkedList.Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes the element at the specified index.
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if index is invalid
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        src.MyLinkedList.Node node = getNode(index);

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        size--;
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
        return getNode(index).data;
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
     * Retrieves the node at the specified index efficiently.
     * Traverses from head or tail based on proximity.
     * @param index the index of the node
     * @return the node at the specified index
     */
    private src.MyLinkedList.Node getNode(int index) {
        src.MyLinkedList.Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
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
     * Provides an iterator to traverse the list from head to tail.
     * @return an iterator over the list elements
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private src.MyLinkedList.Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}