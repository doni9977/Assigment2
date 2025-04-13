package src;
/**
 * Test class for MyArrayList, MyLinkedList, MyStack, MyQueue, and MyMinHeap.
 * Verifies the functionality of all data structures.
 */
public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList size: " + arrayList.size()); // Expected: 3
        System.out.println("Element at index 1: " + arrayList.get(1)); // Expected: 2
        arrayList.remove(0);
        System.out.println("ArrayList size after remove: " + arrayList.size()); // Expected: 2
        System.out.println("Elements via iterator:");
        for (Integer item : arrayList) {
            System.out.print(item + " "); // Expected: 2 3
        }
        System.out.println();

        // Test MyLinkedList
        System.out.println("\nTesting MyLinkedList:");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println("LinkedList size: " + linkedList.size()); // Expected: 3
        System.out.println("Element at index 1: " + linkedList.get(1)); // Expected: b
        linkedList.remove(1);
        System.out.println("LinkedList size after remove: " + linkedList.size()); // Expected: 2
        System.out.println("Elements via iterator:");
        for (String item : linkedList) {
            System.out.print(item + " "); // Expected: a c
        }
        System.out.println();

        // Test MyStack
        System.out.println("\nTesting MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack size: " + stack.size()); // Expected: 3
        System.out.println("Stack top: " + stack.peek()); // Expected: 30
        System.out.println("Stack pop: " + stack.pop()); // Expected: 30
        System.out.println("Stack size after pop: " + stack.size()); // Expected: 2
        System.out.println("Elements via iterator:");
        for (Integer item : stack) {
            System.out.print(item + " "); // Expected: 20 10
        }
        System.out.println();

        // Test MyQueue
        System.out.println("\nTesting MyQueue:");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        System.out.println("Queue size: " + queue.size()); // Expected: 3
        System.out.println("Queue front: " + queue.peek()); // Expected: first
        System.out.println("Queue dequeue: " + queue.dequeue()); // Expected: first
        System.out.println("Queue size after dequeue: " + queue.size()); // Expected: 2
        System.out.println("Elements via iterator:");
        for (String item : queue) {
            System.out.print(item + " "); // Expected: second third
        }
        System.out.println();

        // Test MyMinHeap
        System.out.println("\nTesting MyMinHeap:");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);
        System.out.println("MinHeap size: " + minHeap.size()); // Expected: 3
        System.out.println("MinHeap deleteMin: " + minHeap.deleteMin()); // Expected: 1
        System.out.println("MinHeap size after deleteMin: " + minHeap.size()); // Expected: 2
        System.out.println("Elements via iterator (array order):");
        for (Integer item : minHeap) {
            System.out.print(item + " "); // Expected: 2 3 (or heap structure dependent)
        }
        System.out.println();
    }
}