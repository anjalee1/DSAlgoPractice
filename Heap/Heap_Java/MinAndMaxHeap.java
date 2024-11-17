import java.util.Arrays;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the Min Heap
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;
        int current = size - 1;
        while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public int extractMin() {
        if (size == 0) return Integer.MIN_VALUE;
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && heap[left] < heap[smallest]) smallest = left;
        if (right < size && heap[right] < heap[smallest]) smallest = right;
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }
}

class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;
        int current = size - 1;
        while (current > 0 && heap[current] > heap[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public int extractMax() {
        if (size == 0) return Integer.MAX_VALUE;
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && heap[left] > heap[largest]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }
}

public class Main {
    public static void main(String[] args) {
        // Testing MinHeap
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);
        System.out.println("Min Heap:");
        minHeap.printHeap();
        System.out.println("Extract Min: " + minHeap.extractMin());
        minHeap.printHeap();

        // Testing MaxHeap
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        System.out.println("\nMax Heap:");
        maxHeap.printHeap();
        System.out.println("Extract Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}
