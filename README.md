# Assigment2
# Project Overview
The goal of this project is to implement and test fundamental data structures without relying on Java's standard library (except Iterator). The data structures are:

MyArrayList: A dynamic array-based list supporting resizing.
MyLinkedList: A doubly linked list for efficient insertions and deletions.
MyStack: A LIFO stack built on MyArrayList.
MyQueue: A FIFO queue built on MyLinkedList.
MyMinHeap: A min-heap built on MyArrayList for priority queue operations.
All classes are generic, supporting any data type (MyMinHeap requires comparable types). The code is thoroughly documented with Javadoc and inline comments for clarity.
MyArrayList: Uses a resizable Object[], doubling capacity when full for amortized O(1) additions.
MyLinkedList: Prevents loops by carefully managing next and prev references in a doubly linked structure.
MyStack: Chosen over MyLinkedList for simplicity and cache-friendly array access.
MyQueue: Uses MyLinkedList for O(1) enqueue (tail) and dequeue (head) operations.
MyMinHeap: Uses MyArrayList for efficient array-based indexing in heap operations.
