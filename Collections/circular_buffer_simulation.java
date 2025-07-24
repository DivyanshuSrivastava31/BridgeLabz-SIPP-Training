import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CircularBuffer<T> {
    private T[] buffer;
    private int capacity;
    private int head; // Index of the oldest element
    private int tail; // Index where the next element will be inserted
    private int size; // Current number of elements in the buffer

    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(T element) {
        buffer[tail] = element;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            // If buffer is full, head also moves to overwrite the oldest element
            head = (head + 1) % capacity;
        }
    }

    public T remove() {
        if (isEmpty()) {
            return null; // Or throw NoSuchElementException
        }
        T element = buffer[head];
        buffer[head] = null; // Clear the element
        head = (head + 1) % capacity;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        List<T> currentElements = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            currentElements.add(buffer[(head + i) % capacity]);
        }
        return currentElements.toString();
    }

    public static void main(String[] args) {
        int bufferSize = 3;
        CircularBuffer<Integer> buffer = new CircularBuffer<>(bufferSize);
        System.out.println("Buffer size=" + bufferSize + ":");

        System.out.print("Insert 1, 2, 3 → ");
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer: " + buffer); // Expected:

        System.out.print("Insert 4 → ");
        buffer.insert